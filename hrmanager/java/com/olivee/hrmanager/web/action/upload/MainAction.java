package com.olivee.hrmanager.web.action.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.olivee.web.apache.fileupload.MonitoredDiskFileItemFactory;
import com.olivee.web.apache.fileupload.UploadInfo;
import com.olivee.web.apache.fileupload.UploadListener;

@Controller("upload.MainAction")
public class MainAction {
	
	private String uploadAbsolutPath = "tmp";
	
	@RequestMapping("/upload/tmp/image")
	@SuppressWarnings("unchecked")
	public void upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tokenid = request.getParameter("tokenid");
		UploadListener listener = new UploadListener(tokenid, request);
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (!isMultipart) {
			listener.error("not multipart content!");
			return;
		}

		try {
			FileItemFactory factory = new MonitoredDiskFileItemFactory(listener);
			ServletFileUpload fileload = new ServletFileUpload(factory);
			fileload.setSizeMax(1977085990);// 4MB 4194304
			List<FileItem> files = fileload.parseRequest(request);
			Iterator<FileItem> iterator = files.iterator();
			Map<String, String> params = new HashMap<String, String>();
			FileItem uploadItem = null;
			while (iterator.hasNext()) {
				FileItem item = iterator.next();
				if (item.isFormField()) {
					params.put(item.getFieldName(), item.getString());
				} else {
					uploadItem = item;
				}
			}
			if (uploadItem != null) {
				String saveName = UUID.randomUUID().toString().replaceAll("-", "") + ".jpg";
				String saveRelativePath = uploadAbsolutPath + "/" + saveName;
				String savePath = request.getSession(true).getServletContext().getRealPath("") + "/" + saveRelativePath;
				processUploadedFile(listener, uploadItem, params, savePath);
				listener.success("{'image':'".concat(saveRelativePath).concat("'}"));
			} else {
				listener.error("no upload item");
			}
		} catch (Exception e) {
			listener.error(e.getLocalizedMessage());
		}

	}

	private void processUploadedFile(UploadListener listener,
			FileItem uploadItem, Map<String, String> params, String savePath) throws Exception  {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			if(new File(savePath).getParentFile().exists()){
				new File(savePath).getParentFile().mkdirs();
			}
			InputStream in = uploadItem.getInputStream();
			bis = new BufferedInputStream(in);
			bos = new BufferedOutputStream(
					new FileOutputStream(savePath));
			byte[] buffer = new byte[1024 * 256];
			for (int size = 0; (size = bis.read(buffer)) > 0;) {
				bos.write(buffer, 0, size);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if(bis!=null)
				try {
					bis.close();
				} catch (IOException e) {}
			if(bos!=null)
				try {
					bos.close();
				} catch (IOException e) {}
		}

	}
	
	@RequestMapping("/upload/tmp/image/status")
	public UploadInfo status(HttpServletRequest request) {
		return (UploadInfo)request.getSession(true).getAttribute(request.getParameter("tokenid"));
		
	}

}
