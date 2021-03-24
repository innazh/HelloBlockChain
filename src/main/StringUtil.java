package main;

import java.security.MessageDigest;

public class StringUtil {
	//Applies Sha256 to a string and returns the result
	public static String applySha256(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			//Applies sha256 to our input, 
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			// This will contain hash as hexidecimal
			StringBuffer hexStr = new StringBuffer(); 
			
			for (int i=0; i<hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexStr.append('0');
				hexStr.append(hex);
			}
			
			return hexStr.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
			//wtf why are we throwing here?
			//probably to catch it in the function we're calling this in
		}
	}
}
