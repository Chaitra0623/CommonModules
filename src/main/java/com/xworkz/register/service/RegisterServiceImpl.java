package com.xworkz.register.service;

import java.util.Objects;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.xworkz.register.dao.RegisterDAO;
import com.xworkz.register.dto.RegisterDTO;
import com.xworkz.register.entity.RegisterEntity;
import com.xworkz.register.exceptions.ServiceException;

@Component
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterDAO registerDAO;

	public RegisterServiceImpl() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}

	public boolean validateandsave(RegisterDTO registerDTO) {
		boolean valid = false;
		try {
			System.out.println("dataSave invoked " + registerDTO);
			if (Objects.nonNull(registerDTO)) {
				System.out.println("starting validation for " + registerDTO);
				String userId = registerDTO.getUserId();
				if (userId != null && !userId.isEmpty() && userId.length() > 2 && userId.length() < 10) {
					System.out.println("userId is valid");
					valid = true;
				} else {
					System.out.println("userId is invalid");
					valid = false;
					return valid;
				}
				String email = registerDTO.getEmail();
				if (email != null && !email.isEmpty()) {
					System.out.println("email is valid");
					valid = true;
				} else {
					System.out.println("email is invalid");
					valid = false;
					return valid;
				}
				String phoneNum = registerDTO.getPhoneNum();
				if (phoneNum != null && !phoneNum.isEmpty() && phoneNum.length() > 2 && phoneNum.length() < 10) {
					System.out.println("phoneNum is valid");
					valid = true;
				} else {
					System.out.println("phoneNum is invalid");
					valid = false;
					return valid;
				}
				String courseInterested = registerDTO.getCourseInterested();
				if (courseInterested != null && !courseInterested.isEmpty()) {
					System.out.println("courseInterested is valid");
					valid = true;
				} else {
					System.out.println("courseInterested is invalid");
					valid = false;
					return valid;
				}
				String agree = registerDTO.getAgree();
				if (agree != null && !agree.isEmpty() && agree.equals("Agree") ) {
					System.out.println("user as agreed");
					valid = true;
				} else {
					System.out.println(" user as not agreed ");
					valid = false;
					return valid;
				}
				
				
			}
		
			if (valid ) {
				System.out.println("Data is valid ,will convert  to entity");

				RegisterEntity registerEntity = new RegisterEntity();

				BeanUtils.copyProperties(registerDTO, registerEntity);
				RegisterEntity registerEntity1 = registerDAO.fetchbyuserId(registerDTO.getUserId());
				RegisterEntity registerEntity2 =registerDAO.feachbyemail(registerDTO.getEmail());
				if (registerEntity1 == null && registerEntity2==null) {
					System.out.println("entity is ready \t " + registerEntity);
					String randomPassword = RandomStringUtils.randomAlphanumeric(5);
					registerEntity.setPassword(randomPassword);
					registerDAO.save(registerEntity);
					BeanUtils.copyProperties(registerEntity, registerDTO);
					System.out.println("entity is saved");
				} else {
					System.out.println("ENTITY AS  SAVED USERID  And EMAIL ALREADY Exits");
					valid = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();	
}
		return valid;

	}
}
