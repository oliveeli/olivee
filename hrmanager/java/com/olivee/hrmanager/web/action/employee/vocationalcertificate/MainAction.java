package com.olivee.hrmanager.web.action.employee.vocationalcertificate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olivee.hrmanager.web.entity.HrVocationalCertificate;
import com.olivee.hrmanager.web.logic.HrVocationalCertificateLogic;

@Controller("vocationalcertificate.MainAction")
public class MainAction {

	@Autowired
	private HrVocationalCertificateLogic hrVocationalCertificateLogic;
	
	
	@RequestMapping("/user/vocational/certificate/list")
	@ResponseBody
	public List<HrVocationalCertificate> orglist(@RequestParam("userId") String userId) {
		return hrVocationalCertificateLogic.getListByUserId(userId);
	}
	
	@RequestMapping("/user/vocational/certificate/get")
	@ResponseBody
	public HrVocationalCertificate getDetail(@RequestParam("userId") String userId) {
		return hrVocationalCertificateLogic.getDetail(userId);
	}
	
	@RequestMapping("/user/vocational/certificate/create")
	@ResponseBody
	public HrVocationalCertificate save(@RequestBody HrVocationalCertificate instance) {
		return hrVocationalCertificateLogic.save(instance);
	}
	
	@RequestMapping("/user/vocational/certificate/update")
	@ResponseBody
	public HrVocationalCertificate update(@RequestBody HrVocationalCertificate instance) {
		return hrVocationalCertificateLogic.update(instance);
	}
	
	@RequestMapping("/user/vocational/certificate/remove")
	@ResponseBody
	public void remove(@RequestBody HrVocationalCertificate instance) {
		hrVocationalCertificateLogic.delete(instance);
	}
	
}
