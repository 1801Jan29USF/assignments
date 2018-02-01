package Week1HW.q15;

/**
 * Functionality: Demonstrates the implementation of an interface with four operands.
 */
public class MathTester {
    public static void main(String[] args) {
        MathImplementation mi = new MathImplementation();
        System.out.println("1 + 2 = " + mi.add(1, 2));
        System.out.println("5 - 6 - 4 - 29 = " + mi.subtract(5, 6, 4, 29));
    }
}
