package com.olivee.hrmanager.web.action.employee.award;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olivee.hrmanager.web.entity.HrAwardWinning;
import com.olivee.hrmanager.web.logic.HrAwardWinningLogic;

@Controller("award.MainAction")
public class MainAction {

	@Autowired
	private HrAwardWinningLogic hrAwardWinningLogic;
	
	@RequestMapping("/user/award/list")
	@ResponseBody
	public List<HrAwardWinning> orglist(@RequestParam("userId") String userId) {
		return hrAwardWinningLogic.getListByUserId(userId);
	}
	
	@RequestMapping("/user/award/get")
	@ResponseBody
	public HrAwardWinning getDetail(@RequestParam("userId") String userId) {
		return hrAwardWinningLogic.getDetail(userId);
	}
	
	@RequestMapping("/user/award/create")
	@ResponseBody
	public HrAwardWinning save(@RequestBody HrAwardWinning instance) {
		return hrAwardWinningLogic.save(instance);
	}
	
	@RequestMapping("/user/award/update")
	@ResponseBody
	public HrAwardWinning update(@RequestBody HrAwardWinning instance) {
		return hrAwardWinningLogic.update(instance);
	}
	
	@RequestMapping("/user/award/remove")
	@ResponseBody
	public void remove(@RequestBody HrAwardWinning instance) {
		hrAwardWinningLogic.delete(instance);
	}
	
}
