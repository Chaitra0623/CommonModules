package com.xworkz.register.dao;

import com.xworkz.register.entity.RegisterEntity;

public interface LoginDAO {
	public RegisterEntity feachbyemail(String email);
	public RegisterEntity fetchbypassword(String password);
	 public Integer validLoginUser(String email,String password);
	 public Integer	feachAttempt(String email ) ;
	 public Integer	updateAttempt(String email, int noOfAttempt ) ;


}
