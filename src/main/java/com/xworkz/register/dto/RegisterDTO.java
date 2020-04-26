package com.xworkz.register.dto;

public class RegisterDTO {
	 private String userId;
	 private String email;
	 private String phoneNum;
	 private String courseInterested;
	 private String agree;
	 private String password;
	 public RegisterDTO() {
		System.out.println("created "+this.getClass().getSimpleName());
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	/*public RegisterDTO(String userId, String email, String phoneNum, String courseInterested, String agree,
			String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.phoneNum = phoneNum;
		this.courseInterested = courseInterested;
		this.agree = agree;
		this.password = password;
	}*/
	@Override
	public String toString() {
		System.out.println("invokeing toString methode "+this.password);
		return "RegisterDTO [userId=" + userId + ", email=" + email + ", phoneNum=" + phoneNum + ", courseInterested="
				+ courseInterested + ", agree=" + agree + ", password=" + password + "]";
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getCourseInterested() {
		return courseInterested;
	}
	public void setCourseInterested(String courseInterested) {
		this.courseInterested = courseInterested;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}