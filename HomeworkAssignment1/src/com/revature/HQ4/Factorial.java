package com.revature.HQ4;

public class Factorial 
{
	public static void main(String[] args) 
	{
		int N = 10, sum = 1;
		
		while(N >= 1)
		{
			sum *= N;
			N--;
		}
		System.out.println(sum);
	}
}
