package com.olivee.log.log4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import com.olivee.log.log4j.web.MDCFilter;

public class OliveeAppender extends AppenderSkeleton implements Appender{
	
	private LogDataHandler logDataHandler;
	
	public OliveeAppender(){
		logDataHandler = new LogDataHandler();
	}
	
	private String system;

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	@Override
	public void close() {

	}

	@Override
	public boolean requiresLayout() {
		return false;
	}

	@Override
	protected void append(LoggingEvent event) {	    
	    event.getThreadName();
	    event.getMDCCopy();
	    event.getRenderedMessage();
	    event.getThrowableStrRep();
		
	    LogData data = new LogData();
	    data.setMessage(event.getMessage().toString());
	    data.setTimeStamp(event.getTimeStamp());
	    data.setCatalog(event.getLogger().getName());
	    data.setThreadName(event.getThreadName());
	    data.setLevel(event.getLevel().toString());
	    
	    if(event.getThrowableInformation()!=null){
	    	data.setThrowableStrRep(event.getThrowableInformation().getThrowableStrRep());
	    }
	    
	    InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();
			data.setHostName(addr.getHostName());
			data.setHostIp(addr.getHostAddress());
		} catch (UnknownHostException e) {
			System.err.println(e.getMessage());
		}
		
		data.setSystem(this.getSystem());
		data.setUserId((String) event.getMDC(MDCFilter.USER_ID));
		data.setUserName((String) event.getMDC(MDCFilter.USER_NAME));
		data.setUserIp((String) event.getMDC(MDCFilter.USER_IP));
		data.setModel((String) event.getMDC(MDCFilter.USER_SERVLET));
		
		logDataHandler.hand(data);
		

	}

}
