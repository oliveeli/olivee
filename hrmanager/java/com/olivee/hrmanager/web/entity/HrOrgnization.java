package com.olivee.hrmanager.web.entity;

// Generated 2012-9-28 17:46:35 by Hibernate Tools 3.4.0.CR1

/**
 * HrOrgnization generated by hbm2java
 */
public class HrOrgnization implements java.io.Serializable {

	private String id;
	private String superid;
	private String code;
	private String name;

	public HrOrgnization() {
	}

	public HrOrgnization(String id) {
		this.id = id;
	}

	public HrOrgnization(String id, String superid, String code, String name) {
		this.id = id;
		this.superid = superid;
		this.code = code;
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSuperid() {
		return this.superid;
	}

	public void setSuperid(String superid) {
		this.superid = superid;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
