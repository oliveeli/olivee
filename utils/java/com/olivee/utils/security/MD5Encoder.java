package com.olivee.utils.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encoder {
	
	public static String encode(String str){
		
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("No MD5 algorithm");
		}
		
        byte[] digest;
		try {
			digest = messageDigest.digest(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("Encoding UTF-8 failed", e);
		}

        return new String(Hex.encode(digest));
	}
	
}
