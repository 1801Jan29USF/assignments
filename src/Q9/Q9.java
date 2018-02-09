package Q9;

import java.util.ArrayList;

public class Q9 {
	
	//find all primes from 1-100
	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<>();
		a.add(2);
		for(int i = 3; i < 100; i++) {
			boolean flag = true;
			for (int prime : a) {
				if(i%prime == 0) {
					flag = false;
				}
			}
			if(flag) {
				a.add(i);
			}
		}
		System.out.println(a);
	}
}
