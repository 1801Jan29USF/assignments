package com.revature.Q19;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Print sum of all even, odd and removes primes from  1 to 10
 */
public class FunMath {
	public static void main(String[] args) {
		ArrayList<Integer> aL = new ArrayList<Integer>();
		int esum = 0;
		int osum = 0;
		for (int i = 1; i <= 10; i++) {
			aL.add(i);
			if (aL.get(i - 1) % 2 == 0)
				esum += aL.get(i - 1);
			else
				osum += aL.get(i - 1);
		}

		System.out.println(esum);
		System.out.println(osum);
		
		Iterator<Integer> i = aL.iterator();
		while (i.hasNext()) {
			int n = i.next();
			if ((n % 2 != 0 && n != 1 && n != 9) || n == 2)
				i.remove();

		}
		System.out.println(aL);
	}
}
