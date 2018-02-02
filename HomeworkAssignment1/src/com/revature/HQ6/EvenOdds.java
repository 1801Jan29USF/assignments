package com.revature.HQ6;

public class EvenOdds 
{
	public static void main(String[] args) 
	{
		for(int i = 0; i <= 33; i++)
		{
			System.out.println(i + " is " + test(i));
		}
	}
	
	public static String test(int num)
	{
		int a;
		
		a = num/2;
		
		if(a*2 == num)
		{
			return "even";
		}
		else
		{
			return "odd";
		}
	}
}
