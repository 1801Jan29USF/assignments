package com.revature.q13;

import java.util.Scanner;

public class BinaryPyramidLauncher {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many lrows for the triangle: ");
		BinaryPyramid bp = new BinaryPyramid(scan.nextInt());
		bp.printPyramid();
		
	}

}
