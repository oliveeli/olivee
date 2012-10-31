package com.olivee.hrmanager.install.entity;

public class DatabaseConfig {
	String vender, address, port, instance, user, password;

	public String getVender() {
		return vender;
	}

	public void setVender(String vender) {
		this.vender = vender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return super.toString() + "{" + getVender() + "|" + getAddress() + "|"
				+ getPort() + "|" + getInstance() + "|" + getUser() + "|"
				+ getPassword() + "}";
	}

}
