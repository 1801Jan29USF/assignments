package Week1HW.q4;

import java.math.BigInteger;

/**
 * Functionality: Implements the calculation of the nth factorial.
 */
public class NthFactorial {
    BigInteger factorial(BigInteger n){ //we use BigInteger to prevent exceeding the maximum of longs
        if(n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE))return BigInteger.ONE; //base cases, 0! = 1! = 1
        else return (n.multiply(factorial(n.subtract(BigInteger.ONE)))); //recursive calls, n! = n*(n-1)!
    }
}
