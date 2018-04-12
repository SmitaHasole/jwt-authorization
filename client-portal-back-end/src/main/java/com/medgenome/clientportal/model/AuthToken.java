package com.medgenome.clientportal.model;

public class AuthToken {

	private String token;
	private String userName;
	private String role;

	public AuthToken() {

	}

	public AuthToken(String token, String userName, String role) {
		this.token = token;
		this.userName = userName;
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
