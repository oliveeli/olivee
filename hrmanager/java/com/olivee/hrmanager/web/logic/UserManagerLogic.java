package com.olivee.hrmanager.web.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivee.hrmanager.web.dao.HrEmployeeHome;
import com.olivee.hrmanager.web.entity.HrEmployee;

@Service
public class UserManagerLogic {

	@Autowired
	private HrEmployeeHome hrEmployeeHome;
	
	public List<HrEmployee> getUserList(String organizationId){
		return hrEmployeeHome.findByOrganizationId(organizationId);
		
	}

	public HrEmployee save(HrEmployee instance) {
		hrEmployeeHome.persist(instance);
		return instance;
	}

	public HrEmployee update(HrEmployee instance) {
		String id = instance.getId();
		if(id==null || id.trim().equals("")){
			return instance;
		}
		hrEmployeeHome.merge(instance);
		return instance;
	}
	
	public void delete(HrEmployee instance) {
		hrEmployeeHome.delete(instance);
	}

	public HrEmployee getDetail(String userId) {
		return hrEmployeeHome.findById(userId);
	}
	
}
