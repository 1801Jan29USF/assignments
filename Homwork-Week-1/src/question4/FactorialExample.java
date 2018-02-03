package question4;

public class FactorialExample {
	
	//used recursion to compute N factorial
	static int factorial(int n) {
		if (n == 0) {
			return 1;
		}else {
			return(n*factorial(n-1));
					
		}
	}

	public static void main(String[] args) {
		
		int f = 0;
		
		int number= 6; // number to calculate factorial
		
		f = factorial(number); // using factorial to compute the given number
		System.out.println("Factorial number of " + number + " is: " + f);
	}

}
