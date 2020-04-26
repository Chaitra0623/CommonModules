package com.xworkz.register.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
//select registeren0_.NOOFATTEMPT as col_0_0_ from Register_details registeren0_ where registeren0_.EMAIL=?
@Entity
@Table(name = "Register_details")
@NamedQueries({
		@NamedQuery(name = "fetchbyuserId", query = "select sign from RegisterEntity sign where sign.userId=:userId"),
		@NamedQuery(name = "fetchbyemail", query = "select sign from RegisterEntity sign where sign.email=:email  "),
		@NamedQuery(name = "fetchbypassword", query = "select sign from RegisterEntity sign where sign.password=:password  "),
		@NamedQuery(name = "countbyemailpassword", query = "SELECT COUNT(email )FROM RegisterEntity  sign WHERE sign.email=:email and sign.password=:password "),
		@NamedQuery(name = "countbyemail", query = "SELECT sign.noOfAttempt FROM RegisterEntity sign where sign.email=:email"),
		@NamedQuery(name = "incCountbyemail", query = "update RegisterEntity sign set sign.noOfAttempt=:noOfAttempt  where sign.email=:email") })
		//@NamedQuery(name = "countbyemail", query = "SELECT sing email from RegisterEntity  sign WHERE sign.email=:email") })

public class RegisterEntity implements Serializable {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "REGISTER_ID")
	private int id;
	@Column(name = "UERS_ID")
	private String userId;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE_NUMBER")
	private String phoneNum;
	@Column(name = "COURSE_INTERESTED")
	private String courseInterested;
	@Column(name = "AGREE")
	private String agree;
	@Column(name = "PASSWORD")
	private String password;
	@Column (name="NOOFATTEMPT")
	private int noOfAttempt;

	public RegisterEntity() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getNoOfAttempt() {
		return noOfAttempt;
	}

	public void setNoOfAttempt(int noOfAttempt) {
		this.noOfAttempt = noOfAttempt;
	}

	@Override
	public String toString() {
		return "RegisterEntity [id=" + id + ", userId=" + userId + ", email=" + email + ", phoneNum=" + phoneNum
				+ ", courseInterested=" + courseInterested + ", agree=" + agree + ", password=" + password
				+ ", noOfAttempt=" + noOfAttempt + ", getId()=" + getId() + ", getUserId()=" + getUserId()
				+ ", getEmail()=" + getEmail() + ", getPhoneNum()=" + getPhoneNum() + ", getCourseInterested()="
				+ getCourseInterested() + ", getAgree()=" + getAgree() + ", getPassword()=" + getPassword()
				+ ", getNoOfAttempt()=" + getNoOfAttempt() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public RegisterEntity(int id, String userId, String email, String phoneNum, String courseInterested, String agree,
			String password, int noOfAttempt) {
		super();
		this.id = id;
		this.userId = userId;
		this.email = email;
		this.phoneNum = phoneNum;
		this.courseInterested = courseInterested;
		this.agree = agree;
		this.password = password;
		this.noOfAttempt = noOfAttempt;
	}
	
}

	