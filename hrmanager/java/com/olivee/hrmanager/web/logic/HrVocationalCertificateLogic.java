package com.olivee.hrmanager.web.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivee.hrmanager.web.dao.HrVocationalCertificateHome;
import com.olivee.hrmanager.web.entity.HrVocationalCertificate;

@Service
public class HrVocationalCertificateLogic {
	
	@Autowired
	private HrVocationalCertificateHome hrVocationalCertificateHome;
	
	public List<HrVocationalCertificate> getListByUserId(String userid){
		return hrVocationalCertificateHome.findByUserId(userid);
		
	}

	public HrVocationalCertificate save(HrVocationalCertificate instance) {
		hrVocationalCertificateHome.persist(instance);
		return instance;
	}

	public HrVocationalCertificate update(HrVocationalCertificate instance) {
		String id = instance.getId();
		if(id==null || id.trim().equals("")){
			return instance;
		}
		hrVocationalCertificateHome.merge(instance);
		return instance;
	}
	
	public void delete(HrVocationalCertificate instance) {
		hrVocationalCertificateHome.delete(instance);
	}

	public HrVocationalCertificate getDetail(String userId) {
		return hrVocationalCertificateHome.findById(userId);
	}
	
}
