package com.revature.HQ19;

import java.util.ArrayList;

public class ALNumbers {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int evensum = 0;
		int oddsum = 0;
		
		int i = 1;
		while(i <= 10) {
			numbers.add(i);
			i++;
		}
		
		i = 0;
		while(i < 10) {
			if(numbers.get(i)%2 == 0) {
				evensum += numbers.get(i);
			}
			else {
				oddsum += numbers.get(i);
			}
			i++;
		}
		
		i = 0;
		while(i < numbers.size()) {
			System.out.print(numbers.get(i) + ", ");
			i++;
		}
		
		i = 0;
		while(i < numbers.size()) {
			if(isPrime(numbers.get(i))) {
				numbers.remove(i);
				continue;
			}
			i++;
		}
		
		System.out.println("");
		System.out.println("The sum of the even numbers is: " + evensum);
		System.out.println("The sum of the odd numbers is: " + oddsum);
		
		i = 0;
		while(i < numbers.size()) {
			System.out.print(numbers.get(i) + ", ");
			i++;
		}

	}
	
	public static boolean isPrime(int num) {
		
		if (num < 2) {
			return false;
		} 
		else if (num == 2) { 
			return true;
		}
		else if (num % 2 == 0) {
			return false;
		}
		
        for (int i = 3; i * i <= num; i += 2) {
        	
            if (num % i == 0) {
            		return false;
            }
        }
        return true;
	}

}
