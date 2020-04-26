package com.xworkz.register.dao;

import com.xworkz.register.entity.RegisterEntity;

public interface RegisterDAO {
	public RegisterEntity save(RegisterEntity registerEntity );
	public RegisterEntity fetchbyuserId(String userId);
	public RegisterEntity feachbyemail(String email);

}
