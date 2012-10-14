package com.olivee.hrmanager.web.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivee.hrmanager.web.dao.HrFamilyMembersHome;
import com.olivee.hrmanager.web.entity.HrFamilyMembers;

@Service
public class HrFamilyMembersLogic {
	
	@Autowired
	private HrFamilyMembersHome hrFamilyMembersHome;
	
	public List<HrFamilyMembers> getListByUserId(String userid){
		return hrFamilyMembersHome.findByUserId(userid);
		
	}

	public HrFamilyMembers save(HrFamilyMembers instance) {
		hrFamilyMembersHome.persist(instance);
		return instance;
	}

	public HrFamilyMembers update(HrFamilyMembers instance) {
		String id = instance.getId();
		if(id==null || id.trim().equals("")){
			return instance;
		}
		hrFamilyMembersHome.merge(instance);
		return instance;
	}
	
	public void delete(HrFamilyMembers instance) {
		hrFamilyMembersHome.delete(instance);
	}

	public HrFamilyMembers getDetail(String userId) {
		return hrFamilyMembersHome.findById(userId);
	}
	
}
