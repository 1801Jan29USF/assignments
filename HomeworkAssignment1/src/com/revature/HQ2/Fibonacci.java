package com.revature.HQ2;

public class Fibonacci 
{
	public static void main(String[] args)
	{
		int n = 25;
		int cnum = 1;
		int lnum = 0;
		int nNum;
		
		System.out.println(lnum);
		n--;
		System.out.println(cnum);
		n--;
		
		while(n > 0)
		{
			nNum = lnum + cnum;
			System.out.println(nNum);
			lnum = cnum;
			cnum = nNum;
			n--;
		}
	}
}
