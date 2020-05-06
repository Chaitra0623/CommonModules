package com.xworkz.register.dao;

import com.xworkz.register.entity.RegisterEntity;

public interface ForgotPasswordDAO {
	public RegisterEntity feachbyemail(String email);

	public Integer	updateForgot(String password,int noOfAttempt ,String email) ;


}
