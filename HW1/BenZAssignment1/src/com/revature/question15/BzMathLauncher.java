package com.revature.question15;

public class BzMathLauncher {
	public static void main(String[] args) {
		DoMath myMath = new DoMath();
		int first = 10;
		int second = 2;
		
		System.out.println(myMath.bzAdd(first, second));
		System.out.println(myMath.bzSub(first, second));
		System.out.println(myMath.bzMult(first, second));
		System.out.println(myMath.bzDiv(first, second) );
	
	}
}
