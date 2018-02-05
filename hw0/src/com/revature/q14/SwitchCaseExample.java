package com.revature.q14;

import java.util.Calendar;
import java.util.Date;

public class SwitchCaseExample {
	
	private final int SQRT_ME = 64;
	private final String SPLT_ME = "I am learning Core Java";

	public SwitchCaseExample() {
		super();
	}
	
	public void switchCase(int x) {
		switch(x) {
		case 0:	System.out.println(Math.sqrt(SQRT_ME));
				break;
		case 1:	Date today = Calendar.getInstance().getTime();
				System.out.println(today);
				break;
		case 2: String[] strArray;
				strArray = SPLT_ME.split(" ");
				for (int i = 0; i < strArray.length; i++) {
					System.out.println(strArray[i]);
				}
				break;
				
		}
	}
	
}
