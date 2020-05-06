package com.xworkz.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.register.dto.ForgotPasswordDTO;
import com.xworkz.register.service.ForgotPasswordServiceImpl;


@Component
@RequestMapping("/")
public class ForgotPasswordController {
	@Autowired
	private ForgotPasswordServiceImpl forgotPasswordServiceImpl;
	public ForgotPasswordController() {
		System.out.println("created " + this.getClass().getSimpleName());
	}
	@RequestMapping("/Forgot.do")
	public String ForgotPasswordCont(ForgotPasswordDTO forgotPasswordDTO,ModelMap map) { 
		System.out.println("invoking Loginform mehod - login controller");
		try {
			
			String password=this.forgotPasswordServiceImpl.UpdateForgotPassword(forgotPasswordDTO);
			if (password!=null) {
				map.addAttribute("msg", "password updated  \n password is"+password);
			} else
			map.addAttribute("msg", " email dose not  match");

			}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return "ForgotPassword";
		}
		}



