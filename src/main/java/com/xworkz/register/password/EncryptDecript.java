package com.xworkz.register.password;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

public class EncryptDecript {	
private static Random random = new Random((new Date().getTime()));
String st = null;
String enc=encrypt(st);

public static String encrypt(String str) {
	BASE64Encoder encoder = new BASE64Encoder();
	//BASE64EncoderStream encoder = new BASE64EncoderStream();
	
	byte[] salt = new byte[8];
	random.nextBytes(salt);
	
	return encoder.encode(salt)+encoder.encode(str.getBytes());
}
	public static String decrypt(String encstr) {
		if(encstr.length()>12) {
			String cipher = encstr.substring(12);
			
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				return new String(decoder.decodeBuffer(cipher));
			}catch(IOException e){
					e.printStackTrace();
				}
			}
		return encstr;
	

	}}
