package com.keduit.kyj;

public class Member {
	private String username;
	private String password;

	public Member() {

	}

	public Member(String username, String password) {
		this.username = username;
		this.password = password;

	}

	public void setusername(String username) {
		this.username = username;

	}

	public String getusername() {
		return username;

	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getpassword() {
		return password;
	}

}
