package Week1HW.q17;

import java.util.Scanner;

/**
 * Functionality: Demonstrates the functionality of the simple interest calculator
 */
public class SimpleInterestCalcTester {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Principal << ");//prompt for principal
        double principal = s.nextDouble();
        System.out.print("Rate << ");//prompt for rate
        double rate = s.nextDouble();
        System.out.print("Time << ");//prompt for time
        double time = s.nextDouble();
        s.close();//scanner no longer needed
        SimpleInterestCalculator sic = new SimpleInterestCalculator();
        System.out.println("Your interest is $" + sic.calcInterest(principal, rate, time));
    }
}
