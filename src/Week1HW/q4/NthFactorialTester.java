package Week1HW.q4;

import java.math.BigInteger;

/**
 * Functionality: Demonstrates the calculation of the nth factorial.
 */
public class NthFactorialTester {
    public static void main(String[] args) {
        int i = 25;
        BigInteger n = BigInteger.valueOf(i);
        NthFactorial nf = new NthFactorial();
        System.out.println("Factorial of " + n + " is " + nf.factorial(n));
    }
}
