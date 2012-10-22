package com.olivee.hrmanager.web.action.sys.install;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("sys.install.MainAction")
public class MainAction {
	
	@RequestMapping("/sys/install/restart")
	public String restart(){
		OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean();
		String osName = osMxBean.getName();
		boolean isWindows = osName.toLowerCase().startsWith("windows");
		String commandFile = isWindows?"start_tomcat.bat":"start_tomcat.sh";
		String command = isWindows?(commandFile):("sh "+ commandFile);
		return "success";
	}
}
