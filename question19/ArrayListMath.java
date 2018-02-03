package question19;

import java.util.ArrayList;
import java.util.List;

import question9.PrimeCheck;

public class ArrayListMath {

	public static void main(String[] args) {
		PrimeCheck prime = new PrimeCheck();
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) {
			list.add(i);
		}
		
		for(int n: list)
			System.out.println(n);
		
		int evens = 0;
		for(int n: list) {
			if(n % 2 == 0) {
				evens += n; 
			}
		}
		System.out.println("The even numbers add up to: " + evens);
		
		int odds = 0;
		for(int n: list) {
			if(n % 2 != 0) {
				odds += n; 
			}
		}
		System.out.println("The odd numbers add up to: " + odds);
		
		for(int j = list.size() - 1; j >= 0; j--) {
			if(prime.isPrime(j)) {
				list.remove(j);
			}
		}		
		System.out.println("The remaining ArrayList with primes removed: ");
		for(int n: list) {
			System.out.println(n);
		}
	}
	
}
