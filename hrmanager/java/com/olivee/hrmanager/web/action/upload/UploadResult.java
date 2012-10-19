package com.olivee.hrmanager.web.action.upload;

public class UploadResult {
	private String image;
	
	public UploadResult(){}
	
	public UploadResult(String image){
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
