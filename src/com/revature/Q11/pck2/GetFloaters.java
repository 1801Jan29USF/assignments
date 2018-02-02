package com.revature.Q11.pck2;

import com.revature.Q11.Floaters;

/*
 * Class to demonstrate how to access variables from other packages
 */
public class GetFloaters {
	public static void main(String[] args) {
		Floaters f = new Floaters();

		// not ideal but works (public)
		f.float1 = 25 / 2;
		f.float2 = 15 / 2;

		// or using private variables
		f.setFloat4(15 / 2);
		f.setFloat5(11 / 2);

		System.out.println(f.float1 - f.float2);
		System.out.println(f.getFloat4() - f.getFloat5());
	}

}
