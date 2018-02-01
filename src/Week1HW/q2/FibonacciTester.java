package Week1HW.q2;

/**
 * Functionality: Tests the Fibonacci class by printing the fibonacci sequence up to the nth entry.
 */
public class FibonacciTester {
    public static void main(String[] args) {
        int n = 25;
        Fibonacci fib = new Fibonacci();
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + fib.fib(i));
        }
    }
}
