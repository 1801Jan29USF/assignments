package com.revature.HQ5;

public class Substring 
{
	public static void main(String[] args) 
	{
		String test = "Hello";
		System.out.println(sub(test, 2));
	}
	
	private static String sub(String str, int idx)
	{
		String ans = "";
		for(int i = 0; i < idx; i++)
		{
			ans += Character.toString(str.charAt(i));
		}
		
		return ans;
	}
}
