package com.olivee.hrmanager.web.action.employee.family;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olivee.hrmanager.web.entity.HrFamilyMembers;
import com.olivee.hrmanager.web.logic.HrFamilyMembersLogic;

@Controller("family.MainAction")
public class MainAction {

	@Autowired
	private HrFamilyMembersLogic hrFamilyMembersLogic;
	
	@RequestMapping("/user/family/list")
	@ResponseBody
	public List<HrFamilyMembers> orglist(@RequestParam("userId") String userId) {
		return hrFamilyMembersLogic.getListByUserId(userId);
	}
	
	@RequestMapping("/user/family/get")
	@ResponseBody
	public HrFamilyMembers getDetail(@RequestParam("userId") String userId) {
		return hrFamilyMembersLogic.getDetail(userId);
	}
	
	@RequestMapping("/user/family/create")
	@ResponseBody
	public HrFamilyMembers save(@RequestBody HrFamilyMembers instance) {
		return hrFamilyMembersLogic.save(instance);
	}
	
	@RequestMapping("/user/family/update")
	@ResponseBody
	public HrFamilyMembers update(@RequestBody HrFamilyMembers instance) {
		return hrFamilyMembersLogic.update(instance);
	}
	
	@RequestMapping("/user/family/remove")
	@ResponseBody
	public void remove(@RequestBody HrFamilyMembers instance) {
		hrFamilyMembersLogic.delete(instance);
	}
	
}
