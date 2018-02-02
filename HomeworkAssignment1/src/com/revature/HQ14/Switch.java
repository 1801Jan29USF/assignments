package com.revature.HQ14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rand = new Random();
		int input = rand.nextInt(3) + 1;
		
		switch (input) {
		
		case 1:
			System.out.println("The square root of 25.0 is " + Math.sqrt(25));
			break;
			
		case 2:
			DateFormat df = new SimpleDateFormat("dd/MM/yy");
		    Date dateobj = new Date();
			System.out.println("Today's date is " + df.format(dateobj));
			break;
			
		case 3:
			String str = "I am learning Core Java";
			String[] split = str.split(" ");
			System.out.println(Arrays.toString(split));
			break;
			
		default:
			System.out.print("Thank You");
			break;
		
		}
	}

}
