package com.olivee.log.log4j;


public class LogData {

	private String userId, userName, userIp, hostIp, hostName, system, model, catalog, level, threadName, message, locationInformation;
	
	private String[] throwableStrRep;
	
	private long timeStamp;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	
	

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String[] getThrowableStrRep() {
		return throwableStrRep;
	}

	public void setThrowableStrRep(String[] throwableStrRep) {
		this.throwableStrRep = throwableStrRep;
	}
	
	public String getLocationInformation() {
		return locationInformation;
	}

	public void setLocationInformation(String locationInformation) {
		this.locationInformation = locationInformation;
	}

	public String getThrowableStr() {
		if(throwableStrRep!=null){
			StringBuffer sb = new StringBuffer();
			for(int i=0,size=throwableStrRep.length;i<size;i++){
				if(i>0){
					sb.append("\n");
				}
				sb.append(throwableStrRep[i]);
			}
			return sb.toString();
		}
		return null;
	}

}
