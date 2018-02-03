//Q18
package com.revature.superclass;

import java.util.Scanner;

public class SubClass extends Super{

	@Override
	 boolean Upper() {
		String s = "aeyahere";
		for (int i = 0; i < s.length();) {
			char ch = s.charAt(i);
			if(Character.isUpperCase(ch)) {
				System.out.println(true);
				return true;
			}
			else {
				System.out.println(false);
				return false;
			}
			
		}
		return false;
		
	}

	@Override
	String Lower() {
		System.out.println("Enter some txt");
		Scanner scan = new Scanner(System.in);
		
		String f = scan.nextLine();
		
		
		for (int i = 0; i < f.length(); i++) {
			char ch = f.charAt(i);
			if(Character.isLowerCase(ch)) {
				System.out.println(f.toUpperCase());
				
				return f;
				}
			
		
			
		}
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	void Input() {
		System.out.println("Enter a number");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		int result = Integer.parseInt(input);
		System.out.println(result+10);
		// TODO Auto-generated method stub
		
	}

}
