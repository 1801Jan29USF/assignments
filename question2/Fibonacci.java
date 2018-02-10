package question2;

public class Fibonacci {
	
	private void fibSequence(int n) {
		int previous = 0, current = 0, next;
		System.out.println(current);
		current++;
		for (int i = 1; i <= n; i++) {
			next = previous + current;
			previous = current;
			System.out.println(current);
			current = next;
		}
		
	}
	
	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();		
		fib.fibSequence(25);
	}

}
