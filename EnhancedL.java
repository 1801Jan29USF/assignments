package com.revature.enhanced;
//Q12

public class EnhancedL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[ ] = new int [100];
		for (int i = 1; i <= 100; i++) {
				array[i-1] = i;
//				System.out.println(array[i-1]);
			
		}
		
			for( int v1: array) {
				if (v1 % 2 == 0) {
					System.out.println(v1);
					
				}
				
			}
			
		
		

	}

}
