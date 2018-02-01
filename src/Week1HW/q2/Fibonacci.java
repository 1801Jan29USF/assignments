package Week1HW.q2;

/**
 * Functionality: Implements the generation of the nth fibonacci number.
 */
public class Fibonacci {
    int fib(int n){ //recursive method of determining fibonacci sequence numbers
        if(n==0 || n==1)return n; //base cases for the fibonacci sequence
        else return fib(n-1) + fib(n-2); //recursive calls
    }
}
