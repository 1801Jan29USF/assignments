package com.revature.HQ11B;

import com.revature.HQ11A.Phone;

public class FloatLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Phone p = new Phone("IPhone", 128, 4); // this creates a phone object with the size and speed both being floats
	
	System.out.println("The phone is a " + p.size + "GB phone and runs on a " + p.speed + "G network."); // This calls accesses both float-variables by calling them for the print statement
	}

}
