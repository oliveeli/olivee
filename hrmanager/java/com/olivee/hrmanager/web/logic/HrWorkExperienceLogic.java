package com.olivee.hrmanager.web.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivee.hrmanager.web.dao.HrWorkExperienceHome;
import com.olivee.hrmanager.web.entity.HrWorkExperience;

@Service
public class HrWorkExperienceLogic {
	
	@Autowired
	private HrWorkExperienceHome hrWorkExperienceHome;
	
	public List<HrWorkExperience> getListByUserId(String userid){
		return hrWorkExperienceHome.findByUserId(userid);
		
	}

	public HrWorkExperience save(HrWorkExperience instance) {
		hrWorkExperienceHome.persist(instance);
		return instance;
	}

	public HrWorkExperience update(HrWorkExperience instance) {
		String id = instance.getId();
		if(id==null || id.trim().equals("")){
			return instance;
		}
		hrWorkExperienceHome.merge(instance);
		return instance;
	}
	
	public void delete(HrWorkExperience instance) {
		hrWorkExperienceHome.delete(instance);
	}

	public HrWorkExperience getDetail(String userId) {
		return hrWorkExperienceHome.findById(userId);
	}
	
}
