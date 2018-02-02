package com.revature.HQ9;

import java.util.ArrayList;

public class Primes {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		int i = 1;
		while(i <= 100) {
			numbers.add(i);
			i++;
		}
		
		for(int j = 0; j < numbers.size(); j++) {
			if(isPrime(numbers.get(j))) {
				
			System.out.println(numbers.get(j));
			}
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
