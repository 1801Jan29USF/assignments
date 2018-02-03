package com.revature.q3;

import java.util.Scanner;

public class ReverseString {

	public static void main(String args[]) {
		  char name2 ;
		Scanner str= new Scanner(System.in); 
		System.out.println("enter the string: ");
		String name = str.next();
		System.out.println("You entered = " + name);
		
		 char[] chArr = name.toCharArray();
		  
	        for (int i = chArr.length-1; i>=0; i--) 
	          System.out.print(chArr[i]);
	}
}

