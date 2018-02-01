package Week1HW.q5;

/**
 * Functionality: Demonstrates the selection of a substring.
 */
public class SubstringTester {
    public static void main(String[] args) {
        String str = "Hello";
        Substring ss = new Substring();
        System.out.println(str);
        System.out.println(ss.substring(str, 2)); //prints He
    }
}
