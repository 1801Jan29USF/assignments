package com.revature.Q12;

public class Q12 {
	public static void main(String[] args) {
		int a[] = new int[100];
		
		for (int n = 0; n < a.length; n++) {
			a[n] = n + 1;
		}
		for (int i:a) {
			if (i == 100) {
				break;
			}
			if ((a[i] % 2) == 0) {
				System.out.println(a[i]);
			}
		}
	}
}
