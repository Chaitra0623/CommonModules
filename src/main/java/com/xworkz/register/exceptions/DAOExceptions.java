package com.xworkz.register.exceptions;

import org.springframework.stereotype.Component;

@Component
public class DAOExceptions extends RuntimeException {
	private String message = "Exception has occured:" + this.getClass().getSimpleName();
	
	 public DAOExceptions() {
		System.out.println("inside getMessage()...Created :" + this.getClass().getSimpleName());
	}
	 public DAOExceptions(String message) {
			this.message = message;
			System.out.println("inside getMessage()...Created :" + this.getClass().getSimpleName());
		}

		public String getMessage() {
			System.out.println("inside getMessage()..."+message);
			return "message";
		}
}


