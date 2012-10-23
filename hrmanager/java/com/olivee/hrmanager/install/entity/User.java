package com.olivee.hrmanager.install.entity;

import org.apache.catalina.util.MD5Encoder;

import sun.security.provider.MD5;
import sun.security.rsa.RSASignature.MD5withRSA;

public class User {
	String name, password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
