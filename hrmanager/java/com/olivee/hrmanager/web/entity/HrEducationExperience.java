package com.olivee.hrmanager.web.entity;

// Generated 2012-9-28 17:46:35 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * HrEducationExperience generated by hbm2java
 */
public class HrEducationExperience implements java.io.Serializable {

	private String id;
	private String employeeid;
	private String school;
	private String specialty;
	private String educationalLevel;
	private Date beginDate;
	private Date endDate;

	public HrEducationExperience() {
	}

	public HrEducationExperience(String id, String employeeid) {
		this.id = id;
		this.employeeid = employeeid;
	}

	public HrEducationExperience(String id, String employeeid, String school,
			String specialty, String educationalLevel, Date beginDate,
			Date endDate) {
		this.id = id;
		this.employeeid = employeeid;
		this.school = school;
		this.specialty = specialty;
		this.educationalLevel = educationalLevel;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getEducationalLevel() {
		return this.educationalLevel;
	}

	public void setEducationalLevel(String educationalLevel) {
		this.educationalLevel = educationalLevel;
	}

	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
