package com.xworkz.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.register.dto.LoginDTO;
import com.xworkz.register.service.LoginServiceImpl;

@Component
@RequestMapping("/")
public class LoginController {
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	public LoginController() {
		System.out.println("created " + this.getClass().getSimpleName());
	}
	@RequestMapping("/Login.do")
	public String Loginform(LoginDTO loginDTO,ModelMap map) { 
		System.out.println("invoking Loginform mehod - login controller");
		try {
			String valid=this.loginServiceImpl.validateandLogin(loginDTO);
			System.out.println(valid);
			if(valid=="loginSuccessfull") {
				return "AfterLoginHome";
			}else {
				map.addAttribute("failuremessage",valid);
				return "Login";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "Login";
		}
		}
