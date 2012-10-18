package com.olivee.hrmanager.web.action.sys.image;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olivee.hrmanager.web.entity.SysImage;
import com.olivee.hrmanager.web.logic.SysImageLogic;

@Controller("sys.image.MainAction")
public class MainAction {
	
	@Autowired
	private SysImageLogic sysImageLogic;

	@RequestMapping("/sys/image/create")
	@ResponseBody
	public String save(@RequestBody SysImage instance) {
		instance.setId(UUID.randomUUID().toString().replace("-", ""));
		return sysImageLogic.save(instance).getId();
	}
}
