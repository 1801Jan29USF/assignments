package com.revature.HW1.Q13;

public class Triangle {
	public static void main(String[] args) {
		
		String triangle = ""; //beginning string
		
		for(int i = 0; i < 4; i++) {  //for loop, 4 lines deep
			triangle = (i % 2 == 0 ? "0 " : "1 ") + triangle;  // if (i/2) has no remainder, print 0. otherwise 1
			System.out.println(triangle);  //each print adds two characters, 0 or 1 followed by spacing
		}
		
	}

}
