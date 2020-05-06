package com.xworkz.register.dto;

public class ForgotPasswordDTO {
	private String email;
	private int noOfAttempt;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNoOfAttempt() {
		return noOfAttempt;
	}

	public void setNoOfAttempt(int noOfAttempt) {
		this.noOfAttempt = noOfAttempt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ForgotPasswordDTO [email=" + email + ", noOfAttempt=" + noOfAttempt + "]";
	}

	public ForgotPasswordDTO(String email, int noOfAttempt) {
		super();
		this.email = email;
		this.noOfAttempt = noOfAttempt;
	}

	public ForgotPasswordDTO() {
		System.out.println("created ForgotPasswordDTO");
	}
}