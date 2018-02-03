package com.revature.q19;

import java.util.ArrayList;
import java.util.List;



public class EvenOddArrays {
public static void main(String[] args) {
	List<Integer> num= new ArrayList<Integer> ();
	
	
	num.add(1);
	num.add(2);
	num.add(3);
	num.add(4);
	num.add(5); 
	num.add(6);
	num.add(7);
	num.add(8);
	num.add(9);
	num.add(10);
	
	//Displays the list 
	System.out.println("Displays array list of 1-10: " + num);
	
	int sum = 0; 
	
	for (int i= 0; i< num.size(); i++)
	{
		if (num.get(i) %2 ==0)
			 sum = sum +  num.get(i);
	}
	
	System.out.println("Sum of even numbers is: " + sum);
	
	int sumOfOdd = 0;
	
	
	for (int i= 0; i< num.size(); i++)
	{
		if (num.get(i) %2 !=0)
			 sumOfOdd = sumOfOdd +  num.get(i);
	}
	
	System.out.println("Sum of odd numbers is: " + sumOfOdd);
	
	
	for (int i = 0; i <= num.size(); i++)
		
		for (int j = 0; j<= num.get(i) /2; j++)
		{
			if (num.get(i) % j == 0) {
				num.remove(i);
			}
			 
		}
	
	
	System.out.println("List without prime numbers: "+ num);
}


}
