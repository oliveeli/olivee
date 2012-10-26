package com.olivee.log.log4j;

public class LogDataHandler {
	
	private LogDataContainer logDataContainer;

	public LogDataHandler() {
		this.logDataContainer = new LogDataContainer();
		new LogDataHandlerThread("log4j-logdata-handler").start();
	}
	
	public void hand(LogData logData){
		logDataContainer.put(logData);
		synchronized (logDataContainer) { 
			logDataContainer.notifyAll();
		}

	}
	
	class LogDataHandlerThread extends Thread{
		
		ServiceInvokerLogic logic;

		public LogDataHandlerThread(String name) {
			super(name);
			logic = new ServiceInvokerLogic();
		}

		@Override
		public void run() {
			while(true){
				try{
					for(LogData data = null; (data=logDataContainer.get())!=null;){
						saveLog(data);
					}
					synchronized (logDataContainer) {  
						try {
							logDataContainer.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} catch (Throwable e){
					System.out.println("Thread ".concat(this.getName()) + " Error:" + e.getMessage());
				}

			}
		}
		
		private void saveLog(LogData data){
			try {
				logic.saveLogData(data);
			} catch (Throwable e) {
				System.out.println("Thread ".concat(this.getName()) + " Save Log Failed!:" + e.getMessage());
			}
		}
		
	}

}
