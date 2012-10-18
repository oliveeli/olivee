package com.olivee.web.apache.fileupload;

public class UploadInfo {
    public long totalSize = 0;
    public long bytesRead = 0;
    public long elapsedTime = 0;
    public String status = Status.INIT;
    public int fileIndex = 0;
    public String errorMessage;
    public Object result; 
    
    public String[] allFields(){
    	return new String[]{"totalSize", "bytesRead", "elapsedTime", "status", "fileIndex", "errorMessage", "result"};
    }
   
    public UploadInfo()
    {
    }

    public UploadInfo(int fileIndex, long totalSize, long bytesRead, long elapsedTime, String status,String errorMessage, Object result)
    {
        this.fileIndex = fileIndex;
        this.totalSize = totalSize;
        this.bytesRead = bytesRead;
        this.elapsedTime = elapsedTime;
        this.status = status;
        this.errorMessage = errorMessage;
        this.result = result;
    }

    public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public long getTotalSize()
    {
        return totalSize;
    }

    public void setTotalSize(long totalSize)
    {
        this.totalSize = totalSize;
    }

    public long getBytesRead()
    {
        return bytesRead;
    }

    public void setBytesRead(long bytesRead)
    {
        this.bytesRead = bytesRead;
    }

    public long getElapsedTime()
    {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime)
    {
        this.elapsedTime = elapsedTime;
    }

    public int getFileIndex()
    {
        return fileIndex;
    }

    public void setFileIndex(int fileIndex)
    {
        this.fileIndex = fileIndex;
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
