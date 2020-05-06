package com.xworkz.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.register.dto.RegisterDTO;
import com.xworkz.register.exceptions.ControllerException;
import com.xworkz.register.password.EncryptDecript;
import com.xworkz.register.service.RegisterServiceImpl;

@Component
@RequestMapping("/")
public class RegisterController {
	@Autowired
	private RegisterServiceImpl registerServiceImpl;

	public RegisterController() {
		System.out.println("created " + this.getClass().getSimpleName());
	}

	@RequestMapping("/Register.do")
	public String registerform(@RequestParam String agree, RegisterDTO registerDTO, ModelMap map) {
		try {
			System.out.println("my conditions " + agree);
			System.out.println("invoked  save method in  register");
			/*
			 * map.addAttribute("UERS_ID", registerDTO.getUserId());
			 * map.addAttribute("EMAIL", registerDTO.getEmail());
			 * map.addAttribute("PHONE_NUMBER", registerDTO.getPhoneNum());
			 * map.addAttribute("COURSE_INTERESTED", registerDTO.getCourseInterested());
			 * map.addAttribute("AGREE", registerDTO.getAgree());
			 */

			if (registerDTO.getAgree().equals("Agree")) {
				boolean valid = this.registerServiceImpl.validateandsave(registerDTO);
				String NormalPassword=EncryptDecript.decrypt(registerDTO.getPassword());
				if (valid) {
					map.addAttribute("msg", "it is success to save \n password is"+NormalPassword);
				} else {
					map.addAttribute("msg", " userId  and email already save in form ");
				}

				System.out.println(registerDTO);
			} else
				map.addAttribute("msg", " Please agree the form to register ");

		} catch(Exception e) {
			e.printStackTrace();
		}
		return "Register";
	}
}

