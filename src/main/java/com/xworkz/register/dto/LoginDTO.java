package com.xworkz.register.dto;
public class LoginDTO {
	private String email;
	private String password;
	private String noOfAttempt;

	public LoginDTO(String email, String password, String noOfAttempt) {
		super();
		this.email = email;
		this.password = password;
		this.noOfAttempt = noOfAttempt;
	}

	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + ", noOfAttempt=" + noOfAttempt + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNoOfAttempt() {
		return noOfAttempt;
	}

	public void setNoOfAttempt(String noOfAttempt) {
		this.noOfAttempt = noOfAttempt;
	}

	public LoginDTO() {
System.out.println("created \t"+this.getClass().getSimpleName());
}
}

