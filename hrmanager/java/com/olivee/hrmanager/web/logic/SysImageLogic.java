package com.olivee.hrmanager.web.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivee.hrmanager.web.dao.SysImageHome;
import com.olivee.hrmanager.web.entity.SysImage;

@Service
public class SysImageLogic {

	@Autowired
	private SysImageHome sysImageHome;
	
	public SysImage save(SysImage sysImage) {
		sysImageHome.persist(sysImage);
		return sysImage;
	}

	public SysImage get(String id) {
		return sysImageHome.get(id);
	}
}
