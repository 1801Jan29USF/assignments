package com.revature.HQ3;

public class Reversal 
{
	public static void main(String[] args)
	{
		String str = "Hello World";
		int n = str.length();
	
		for(int i = n-1; i >= 0; i--)
		{
			System.out.print(str.charAt(i));
		}
	}
}
