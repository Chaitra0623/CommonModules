package com.xworkz.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.register.dao.LoginDAO;
import com.xworkz.register.dto.LoginDTO;
import com.xworkz.register.entity.RegisterEntity;

@Component
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO loginDAO;

	public LoginServiceImpl() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}

		public String validateandLogin(LoginDTO loginDTO) {
			System.out.println("invoking validateandLogin method - login service");
			try {
				RegisterEntity registerEntity = loginDAO.feachbyemail(loginDTO.getEmail());
				int attemptCount = loginDAO.feachAttempt(loginDTO.getEmail());
				Integer count = loginDAO.validLoginUser(loginDTO.getEmail(), loginDTO.getPassword());
				if (count == 1 && attemptCount <= 2) {
					loginDAO.updateAttempt(loginDTO.getEmail(), 0);
					return "loginSuccessfull";
				} else if (registerEntity != null && attemptCount <= 2) {
					if (attemptCount <= 2) {
						loginDAO.updateAttempt(loginDTO.getEmail(), attemptCount + 1);
						System.out.println("attemptCount-->" + (attemptCount + 1));
					}
					return "email or password is invalid";
				} else if (attemptCount > 2) {
					return "Maximum login Attempts is exceeded";
				}

				else {

					return "email or password is invalid";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "email or password is invalid";
		}
	
}
