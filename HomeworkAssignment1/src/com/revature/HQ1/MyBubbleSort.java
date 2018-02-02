package com.revature.HQ1;

public class MyBubbleSort 
{
	public static void BubbleSort(int[] a)
	{
		int n = a.length;
		int temp = 0;
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 1; j < (n-i); j++)
			{
				if(a[j-1] > a[j])
				{
					temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) 
	{
		int[] num = {1,0,5,6,3,2,3,7,9,8,4};
		
		BubbleSort(num);
	
	
		for(int i = 0; i < num.length; i++)
		{
			System.out.print(num[i] + " ");
		}
	}
}
