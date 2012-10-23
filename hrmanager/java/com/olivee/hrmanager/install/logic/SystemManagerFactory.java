package com.olivee.hrmanager.install.logic;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class SystemManagerFactory {
	
	private static SystemManager systemManager;
	
	public static SystemManager getSystemManager(){
		if(systemManager==null){
			OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean();
			String osName = osMxBean.getName();
			boolean isWindows = osName.toLowerCase().startsWith("windows");
			systemManager = isWindows? new WindowsSystemManager(): new LinuxSystemManager();
		}
		return systemManager;
	}

}
