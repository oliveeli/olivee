package com.olivee.hrmanager.install.logic;

import java.io.IOException;

public class LinuxSystemManager implements SystemManager{

	@Override
	public void restartTomcat() {
		String commandFile = "start_tomcat.sh";
		String command ="sh "+ commandFile;
		try {
			Process  p = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
