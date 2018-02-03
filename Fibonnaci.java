package com.revature.fibonacci;
//Q2
public class Fibonnaci {
	
	 static  int fib(int num) {
		int f[]=  new int[num+1];
		f[0]  = 0;
		f[1] = 1;
		System.out.println(f[0]);
		System.out.println(f[1]);
		for (int i = 2; i <= num; i++) {
			f[i] =f[i-1] + f[i-2];
			System.out.println(f[i]);
			
		}
		return f[num];
	 }
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	fib(25);
		

	}

}
