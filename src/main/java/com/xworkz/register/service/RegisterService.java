package com.xworkz.register.service;

import org.springframework.ui.ModelMap;

import com.xworkz.register.dto.RegisterDTO;

public interface RegisterService {
	public boolean validateandsave(RegisterDTO  registerDTO);
}