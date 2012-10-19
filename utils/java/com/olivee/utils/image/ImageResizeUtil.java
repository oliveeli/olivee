package com.olivee.utils.image;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.olivee.utils.io.FileUtil;

public class ImageResizeUtil {
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
	
	public static void resize(String inputFilePath, String outPutFilePath, int witdh, int height) throws ImageResizeException{
		BufferedImage originalImage;
		try {
			originalImage = ImageIO.read(new File(inputFilePath));
		} catch (IOException e) {
			throw new ImageResizeException("Read file [".concat(inputFilePath).concat("] Exception"), e);
		}
		String suffix = FileUtil.getFileSuffix(inputFilePath);
		suffix = (suffix==null || suffix.equals(""))?"jpg":suffix;
		int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		BufferedImage resizeImageHintJpg = resizeImageWithHint(originalImage, type, witdh, height);
		try {
			ImageIO.write(resizeImageHintJpg, suffix, new File(outPutFilePath));
		} catch (IOException e) {
			throw new ImageResizeException("Write resize image file failed!", e);
		} 
	}
	
	/**
	 * enlarge image
	 * @param inputFilePath
	 * @param outPutFilePath
	 * @param witdh
	 * @param height
	 * @throws ImageResizeException
	 */
	public static void enlarge(String inputFilePath, String outPutFilePath, int witdh, int height) throws ImageResizeException{
		BufferedImage originalImage;
		try {
			originalImage = ImageIO.read(new File(inputFilePath));
		} catch (IOException e) {
			throw new ImageResizeException("Read file [".concat(inputFilePath).concat("] Exception"), e);
		}
		int originalW = originalImage.getWidth();
		int originalH = originalImage.getHeight();
		witdh = originalW>witdh?originalW:witdh;
		height = originalH>height?originalH:height;
		resize(inputFilePath, outPutFilePath, witdh, height);
	}
	
	/**
	 * minifye image file
	 * @param inputFilePath
	 * @param outPutFilePath
	 * @param witdh
	 * @param height
	 * @throws ImageResizeException
	 */
	public static void minifye(String inputFilePath, String outPutFilePath, int witdh, int height) throws ImageResizeException{
		BufferedImage originalImage;
		try {
			originalImage = ImageIO.read(new File(inputFilePath));
		} catch (IOException e) {
			throw new ImageResizeException("Read file [".concat(inputFilePath).concat("] Exception"), e);
		}
		int originalW = originalImage.getWidth();
		int originalH = originalImage.getHeight();
		witdh = originalW<witdh?originalW:witdh;
		height = originalH<height?originalH:height;
		resize(inputFilePath, outPutFilePath, witdh, height);
	}
}
