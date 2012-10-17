package com.olivee.utils.image;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.olivee.utils.io.FileUtil;

public class CompressPicUtil {
	private static BufferedImage resizeImageWithHint(
			BufferedImage originalImage, int type, int width, int height) {
		
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
		g.setComposite(AlphaComposite.Src);

		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		return resizedImage;
	}
	
	public static void compress(String inputFilePath, String outPutFilePath, int witdh, int height) throws CompressException{
		BufferedImage originalImage;
		try {
			originalImage = ImageIO.read(new File(inputFilePath));
		} catch (IOException e) {
			throw new CompressException("Read file [".concat(inputFilePath).concat("] Exception"), e);
		}
		String suffix = FileUtil.getFileSuffix(inputFilePath);
		suffix = (suffix==null || suffix.equals(""))?"jpg":suffix;
		int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		BufferedImage resizeImageHintJpg = resizeImageWithHint(originalImage, type, witdh, height);
		try {
			ImageIO.write(resizeImageHintJpg, suffix, new File(outPutFilePath));
		} catch (IOException e) {
			throw new CompressException("Write resize image file failed!", e);
		} 
		
	}
}
