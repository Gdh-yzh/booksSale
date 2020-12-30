package com.web.util;

import java.security.MessageDigest;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Md5Code {
	
	public static String createMD5Code(String code) throws Exception{
		MessageDigest digest = MessageDigest.getInstance("MD5");
		byte[] b = digest.digest(code.getBytes());
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(b);
	}
	
	public static void main(String[] args) throws Exception{
		String code = Md5Code.createMD5Code("hello");
		System.out.println(code);
	}
}
