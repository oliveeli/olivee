package com.olivee.hrmanager.web.action.employee.education;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olivee.hrmanager.web.entity.HrEducationExperience;
import com.olivee.hrmanager.web.logic.HrEducationExperienceLogic;

@Controller("education.MainAction")
public class MainAction {

	@Autowired
	private HrEducationExperienceLogic hrEducationExperienceLogic;
	
	@RequestMapping("/user/education/list")
	@ResponseBody
	public List<HrEducationExperience> orglist(@RequestParam("userId") String userId) {
		return hrEducationExperienceLogic.getListByUserId(userId);
	}
	
	@RequestMapping("/user/education/get")
	@ResponseBody
	public HrEducationExperience getDetail(@RequestParam("userId") String userId) {
		return hrEducationExperienceLogic.getDetail(userId);
	}
	
	@RequestMapping("/user/education/create")
	@ResponseBody
	public HrEducationExperience save(@RequestBody HrEducationExperience instance) {
		return hrEducationExperienceLogic.save(instance);
	}
	
	@RequestMapping("/user/education/update")
	@ResponseBody
	public HrEducationExperience update(@RequestBody HrEducationExperience instance) {
		return hrEducationExperienceLogic.update(instance);
	}
	
	@RequestMapping("/user/education/remove")
	@ResponseBody
	public void remove(@RequestBody HrEducationExperience instance) {
		hrEducationExperienceLogic.delete(instance);
	}
	
}
