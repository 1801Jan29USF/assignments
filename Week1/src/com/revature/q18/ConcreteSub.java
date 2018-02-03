package com.revature.q18;

public class ConcreteSub extends SupperAb{

	@Override
	public boolean checkUpper(String str1) {
		// TODO Auto-generated method stub
		return  (Character.isUpperCase(str1.toCharArray()));
		
		
		
	}

	@Override
	public String lowerToUpper(String str1) {
		// TODO Auto-generated method stub
		
		return str1.toUpperCase();
	}

	@Override
	public void strToInt(String str1) {
		// TODO Auto-generated method stub
		int afterConvert = Integer.parseInt(str1);
		int afterAdd = afterConvert + 10;
		
		System.out.println("After string to integer and adding 10 = " +  afterConvert);
		
	}

}
