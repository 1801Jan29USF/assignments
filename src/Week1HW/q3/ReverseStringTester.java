package Week1HW.q3;

/**
 * Functionality: Demonstrates the reversal of strings.
 */
public class ReverseStringTester {
    public static void main(String[] args) {
        String s = "Hello World!";
        ReverseString rs = new ReverseString();
        System.out.println("Before reversal: " + s);
        System.out.println("After reversal: " + rs.reverseString(s));
    }
}
