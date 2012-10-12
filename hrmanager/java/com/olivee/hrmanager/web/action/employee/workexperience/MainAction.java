package com.olivee.hrmanager.web.action.employee.workexperience;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olivee.hrmanager.web.entity.HrWorkExperience;
import com.olivee.hrmanager.web.logic.HrWorkExperienceLogic;

@Controller("workexperience.MainAction")
public class MainAction {

	@Autowired
	private HrWorkExperienceLogic hrWorkExperienceLogic;
	
	@RequestMapping("/user/work/experience/list")
	@ResponseBody
	public List<HrWorkExperience> orglist(@RequestParam("userId") String userId) {
		return hrWorkExperienceLogic.getListByUserId(userId);
	}
	
	@RequestMapping("/user/work/experience/get")
	@ResponseBody
	public HrWorkExperience getDetail(@RequestParam("userId") String userId) {
		return hrWorkExperienceLogic.getDetail(userId);
	}
	
	@RequestMapping("/user/work/experience/create")
	@ResponseBody
	public HrWorkExperience save(@RequestBody HrWorkExperience instance) {
		return hrWorkExperienceLogic.save(instance);
	}
	
	@RequestMapping("/user/work/experience/update")
	@ResponseBody
	public HrWorkExperience update(@RequestBody HrWorkExperience instance) {
		return hrWorkExperienceLogic.update(instance);
	}
	
	@RequestMapping("/user/work/experience/remove")
	@ResponseBody
	public void remove(@RequestBody HrWorkExperience instance) {
		hrWorkExperienceLogic.delete(instance);
	}
	
}
