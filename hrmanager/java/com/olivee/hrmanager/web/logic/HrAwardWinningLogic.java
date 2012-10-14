package com.olivee.hrmanager.web.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivee.hrmanager.web.dao.HrAwardWinningHome;
import com.olivee.hrmanager.web.entity.HrAwardWinning;

@Service
public class HrAwardWinningLogic {
	
	@Autowired
	private HrAwardWinningHome hrAwardWinningHome;
	
	public List<HrAwardWinning> getListByUserId(String userid){
		return hrAwardWinningHome.findByUserId(userid);
		
	}

	public HrAwardWinning save(HrAwardWinning instance) {
		hrAwardWinningHome.persist(instance);
		return instance;
	}

	public HrAwardWinning update(HrAwardWinning instance) {
		String id = instance.getId();
		if(id==null || id.trim().equals("")){
			return instance;
		}
		hrAwardWinningHome.merge(instance);
		return instance;
	}
	
	public void delete(HrAwardWinning instance) {
		hrAwardWinningHome.delete(instance);
	}

	public HrAwardWinning getDetail(String userId) {
		return hrAwardWinningHome.findById(userId);
	}
}
