package com.olivee.hrmanager.install.logic;

import org.springframework.stereotype.Service;

@Service
public class SysInstallLogic {
	
	private SystemManager systemManager;
	
	public SysInstallLogic(){
		systemManager = SystemManagerFactory.getSystemManager();
	}
	
	public void systemManager(){
		systemManager.restartTomcat();
	}
}
