package question19;

import java.util.ArrayList;

public class ArrayListExample {
	
	//created a method using For loop to check if the numbers are prime
	private static boolean isPrime(int x) {
		for(int i = 2; i< x; i++) {
			if(x% i==0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		//1-10 is added and stored in an arraylist
		ArrayList<Integer> ar = new ArrayList<>();
		int n = 10;
		for(int i = 1; i <= n; i++ ) {
			ar.add(i);
			
		}
		
		//For loop is used to check and calculate the sum of the even numbers
		int evenNum = 0;
		for(int i = 0; i< ar.size(); i++) {
			if(ar.get(i)% 2==0) {
				evenNum+= ar.get(i);
			}
		}
		System.out.println("The sum of the even numbers in the ArrayList is: " + evenNum);
		
		//For loop is used to check and calculate the sum of the odd numbers
		int oddNum= 0;
		for(int i = 0; i< ar.size(); i++) {
			if(ar.get(i)% 2 == 1) {
				oddNum += ar.get(i);
			}
		}
		System.out.println("The sum of the odd numbers in the ArrayList is: " + oddNum);

		//checks to to see if there is prime numbers, and prints out result without prime numbers
		for(int i = 0; i< ar.size(); i++) {
			if(isPrime(ar.get(i))) {
				ar.remove(i);
				i--;
			}
		}
		System.out.println("The result of the ArrayList without prime number: " );
		for(int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i));
		}

	}

}
