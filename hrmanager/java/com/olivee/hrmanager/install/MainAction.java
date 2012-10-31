package com.olivee.hrmanager.install;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olivee.hrmanager.install.entity.DatabaseConfig;
import com.olivee.hrmanager.install.entity.User;
import com.olivee.hrmanager.install.logic.SystemInstallLogic;
import com.olivee.hrmanager.web.action.ResultMessage;

@Controller("sys.install.MainAction")
public class MainAction {
	
	@Autowired
	private SystemInstallLogic systemInstallLogic;

	@RequestMapping("restart")
	@ResponseBody
	public String restart() {
		OperatingSystemMXBean osMxBean = ManagementFactory
				.getOperatingSystemMXBean();
		String osName = osMxBean.getName();
		boolean isWindows = osName.toLowerCase().startsWith("windows");
		String commandFile = isWindows ? "start_tomcat.bat" : "start_tomcat.sh";
		String command = isWindows ? (commandFile) : ("sh " + commandFile);
		return "success";
	}

	@RequestMapping("db/config")
	@ResponseBody
	public ResultMessage dbConfig(@RequestBody DatabaseConfig dbConfig) {
		
		return systemInstallLogic.saveDbConfig(dbConfig);
	
	}

	@RequestMapping("admin/config")
	@ResponseBody
	public ResultMessage adminConfig(@RequestBody User user) {
		return systemInstallLogic.adminConfig(user);
	}

}
