package Week1HW.q16;

/**
 * Functionality: Takes in a single argument and counts the characters of said argument.
 */
public class ArgsCharCountTester {
    public static void main(String[] args) {
        ArgsCharCount acc = new ArgsCharCount();
        System.out.println(args[0] + " has " + acc.charCount(args[0]) + " characters");
    }
}
