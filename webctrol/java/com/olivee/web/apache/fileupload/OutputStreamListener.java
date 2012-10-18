package com.olivee.web.apache.fileupload;

public abstract class OutputStreamListener {
    abstract void start();
    abstract void bytesRead(int bytesRead);
    abstract void error(String message);
    abstract void success(Object result);  
}
