//
package com.revature.RemovePrime;
//Q19
import java.util.ArrayList;
import java.util.List;

public class RemovePrime {
	
	public static boolean isPrime(int n) {
		if (n<= 1) {
			return false;
			
		}
		int numberofDivisors = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				numberofDivisors++;
				
			}
			
		}
		return numberofDivisors == 2;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stud
		List<Integer> l = new ArrayList<>();
		int sum = 0;
		boolean prime = true;
		for (int i = 2; i <= 10; i++) {
			l.add(i);
			if(isPrime(i)) {
				System.out.println(l.get(i-1));
			}
			//System.out.println(l.get(i-1));	
//			if(l.get(i-1) % 2 == 0) {
//				System.out.println(l.get(i-1));
//				sum += l.get(i-1);
//				
//			}
//			if(l.get(i-1)%2 !=0) {
//				prime = false;
//				System.out.println("hey");
//				System.out.println(l.get(i-1));
//				
//			}else {
//				//System.out.println(l.get(i-1));
//				//l.remove(i);
//				
//			}
			
			
		}
		//System.out.println(sum);
		
		
	}

}
