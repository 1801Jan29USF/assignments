package com.revature.question11;

import com.revature.question11package2.Question11Package2Complete;

public class Question11Complete extends Question11Package2Complete {
	public static void main(String[] args) {
		
		// Creates an object from a class on a different package to 
		// get 2 floats from the other class.
		Question11Package2Complete obj1 = new Question11Package2Complete();
		
		System.out.println("The first float number from the class from another package is: " + obj1.getNum1());
		System.out.println("The second float number from the class from another package is: " + obj1.getNum2());
	}
}
