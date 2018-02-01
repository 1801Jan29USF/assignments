package com.revature.question18;

public class Question18ConcreteComplete extends Question18Abstract {
	public static void main(String[] args) {
		
		// Two strings, one that demonstrates that the two uppercase methods work
		// and one that demonstrates that the int conversion works.
		String str = "kappa";
		String str2 = "20";
		
		// An object of the class used to call the extended methods.
		Question18ConcreteComplete obj = new Question18ConcreteComplete();
		
		System.out.println("It is " + obj.uppercaseChecker(str) + " that there are uppercase letters in the above string.");
		System.out.println(obj.uppercaseConverter(str));
		obj.intConverter(str2);
	}
	
	@Override
	// Uses a for loop to check if all of the chars in a string are uppercase
	// and if it does find an uppercase, then it returns true, and false otherwise.
	public boolean uppercaseChecker(String str) {
		for(int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if(Character.isUpperCase(temp) == true) {
				return true;
			}
		}
		return false;
	}

	@Override
	// Simply converts the input string to all uppercase.
	public String uppercaseConverter(String str) {
		return str.toUpperCase();
	}

	@Override
	// Uses the integer wrapper class to convert the input string to int and then 
	// add 10.
	public void intConverter(String str) {
		System.out.println(Integer.parseInt(str) + 10);
	}
}