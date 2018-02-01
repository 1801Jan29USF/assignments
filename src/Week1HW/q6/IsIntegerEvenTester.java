package Week1HW.q6;

/**
 * Functionality: Demonstrates the testing of whether an integer is even.
 */
public class IsIntegerEvenTester {
    public static void main(String[] args) {
        int i = -20;
        IsIntegerEven iie = new IsIntegerEven();
        System.out.println("Is " + i + " even? It is" + (iie.isEven(i) ? "." : " not."));
    }
}
