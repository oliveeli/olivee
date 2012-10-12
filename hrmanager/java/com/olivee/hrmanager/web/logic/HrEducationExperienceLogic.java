package com.olivee.hrmanager.web.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivee.hrmanager.web.dao.HrEducationExperienceHome;
import com.olivee.hrmanager.web.entity.HrEducationExperience;

@Service
public class HrEducationExperienceLogic {
	
	@Autowired
	private HrEducationExperienceHome hrEducationExperienceHome;
	
	public List<HrEducationExperience> getListByUserId(String userid){
		return hrEducationExperienceHome.findByUserId(userid);
		
	}

	public HrEducationExperience save(HrEducationExperience instance) {
		hrEducationExperienceHome.persist(instance);
		return instance;
	}

	public HrEducationExperience update(HrEducationExperience instance) {
		String id = instance.getId();
		if(id==null || id.trim().equals("")){
			return instance;
		}
		hrEducationExperienceHome.merge(instance);
		return instance;
	}
	
	public void delete(HrEducationExperience instance) {
		hrEducationExperienceHome.delete(instance);
	}

	public HrEducationExperience getDetail(String userId) {
		return hrEducationExperienceHome.findById(userId);
	}
}
