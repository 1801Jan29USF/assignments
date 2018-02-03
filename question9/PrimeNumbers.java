package question9;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
	
	public static void main(String[] args) {
		PrimeCheck prime = new PrimeCheck();
		List<Integer> numbers = new ArrayList<>();
		for(int i = 1; i <= 100; i++) {
			numbers.add(i);
		}
		for(int n: numbers) {
			if(prime.isPrime(n))
				System.out.println(n);
		}
	}

}
