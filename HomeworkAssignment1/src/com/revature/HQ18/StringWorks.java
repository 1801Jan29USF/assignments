package com.revature.HQ18;

public class StringWorks extends StringManipulation {

	public boolean uppercase(String str) {
		//convert String to char array
        char[] characters = str.toCharArray();
        
        for(int i=0; i < characters.length; i++) {
            
            //if any character is not in upper case, return false
            if( Character.isUpperCase( characters[i] )) {
                return true;
            }
        }
        
        return false;
	}
	
	public String convert(String str) {
		return str.toUpperCase();
	}
	
	public int add(String str) {
		 int result = Integer.parseInt(str) + 10;
		return result;
	}
}
