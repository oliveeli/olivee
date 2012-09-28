package com.olivee.hrmanager.web.entity;

// Generated 2012-9-28 17:46:35 by Hibernate Tools 3.4.0.CR1

/**
 * HrFamilyMembers generated by hbm2java
 */
public class HrFamilyMembers implements java.io.Serializable {

	private String id;
	private String employeeid;
	private String relationShip;
	private String name;
	private String birthday;
	private String company;
	private String duty;
	private String telephone;

	public HrFamilyMembers() {
	}

	public HrFamilyMembers(String id, String employeeid) {
		this.id = id;
		this.employeeid = employeeid;
	}

	public HrFamilyMembers(String id, String employeeid, String relationShip,
			String name, String birthday, String company, String duty,
			String telephone) {
		this.id = id;
		this.employeeid = employeeid;
		this.relationShip = relationShip;
		this.name = name;
		this.birthday = birthday;
		this.company = company;
		this.duty = duty;
		this.telephone = telephone;
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

	public String getRelationShip() {
		return this.relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
