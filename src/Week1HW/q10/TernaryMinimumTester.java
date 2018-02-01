package Week1HW.q10;

/**
 * Functionality: Tests the finding of a minimum of two integers using ternary operators.
 */
public class TernaryMinimumTester {
    public static void main(String[] args) {
        int one = 1;
        int two = 2;
        TernaryMinimum tm = new TernaryMinimum();
        System.out.println("Between " + one + " and " + two + ", " + tm.minimum(one, two) + " is the minimum");
    }
}
