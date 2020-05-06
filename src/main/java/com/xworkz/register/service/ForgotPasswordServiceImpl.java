package com.xworkz.register.service;

import java.util.Base64;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.register.dao.ForgotPasswordDAO;
import com.xworkz.register.dto.ForgotPasswordDTO;
import com.xworkz.register.entity.RegisterEntity;
import com.xworkz.register.password.EncryptDecript;

import net.bytebuddy.asm.Advice.Return;
@Component
public class ForgotPasswordServiceImpl implements ForgotPasswordService {
	@Autowired
	private ForgotPasswordDAO forgotPasswordDAO;

	public ForgotPasswordServiceImpl() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}

	public String UpdateForgotPassword(ForgotPasswordDTO forgotPasswordDTO) {
		try {
			System.out.println("dataSave invoked " + forgotPasswordDTO);
			RegisterEntity  registerEntity=forgotPasswordDAO.feachbyemail(forgotPasswordDTO.getEmail());
			if(registerEntity!= null){
				String randomPassword = RandomStringUtils.randomAlphanumeric(8);
				String encryptPassword=EncryptDecript.encrypt(randomPassword);
				System.out.println(encryptPassword+"this is encryptpassword");
				registerEntity.setPassword(encryptPassword);
				
				forgotPasswordDAO.updateForgot(encryptPassword,0,registerEntity.getEmail());
			
			return encryptPassword;
					} 
		}
				catch (Exception e) {
					e.printStackTrace();		
					}
			return  null;
}
}
