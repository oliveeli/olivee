package com.olivee.web.apache.fileupload;

import javax.servlet.http.HttpServletRequest;


public class UploadListener extends OutputStreamListener {

    private HttpServletRequest request;
    private long delay = 0;
    private long startTime = 0;
    private int totalToRead = 0;
    private int totalBytesRead = 0;
    private int totalFiles = -1;
    private String tokenid;
    private String errorMessage;
    private Object result;

	public UploadListener(String tokenid, HttpServletRequest request)
    {
        this.request = request;
        totalToRead = request.getContentLength();
        this.startTime = System.currentTimeMillis();
        this.tokenid = tokenid;
        updateUploadInfo(Status.START);
    }
	
	public void resetTotalBytesRead(){
		totalBytesRead = 0;
	}

    protected void start()
    {
        totalFiles ++;
        updateUploadInfo(Status.START);
    }

    protected void bytesRead(int bytesRead)
    {
        totalBytesRead = totalBytesRead + bytesRead;
        updateUploadInfo(Status.PROGRESS);

        try
        {
            Thread.sleep(delay);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void error(String message)
    {
    	this.errorMessage = message;
        updateUploadInfo(Status.ERROR);
    }
    
    public void success(Object result) {
		this.result = result;
		updateUploadInfo(Status.SUCCESS);
		
	}

    private long getDelta()
    {
        return (System.currentTimeMillis() - startTime) / 1000;
    }

    private void updateUploadInfo(String status)
    {
        long delta = (System.currentTimeMillis() - startTime) / 1000;
        if(tokenid!=null && !tokenid.trim().equals(""))
        	request.getSession().setAttribute(tokenid, new UploadInfo(totalFiles, totalToRead, totalBytesRead,delta,status,errorMessage,result));
    }



}
