package com.xworkz.register.exceptions;

import org.springframework.stereotype.Component;

@Component
public class ServiceException extends RuntimeException {
	private String message = "Exception has occured:" + this.getClass().getSimpleName();
	
	 public ServiceException() {
		System.out.println("inside getMessage()...Created :" + this.getClass().getSimpleName());
	}
	 public ServiceException(String message) {
			this.message = message;
			System.out.println("inside getMessage()...Created :" + this.getClass().getSimpleName());
		}

		public String getMessage() {
			System.out.println("inside getMessage()..."+message);
			return "message";
		}
}


