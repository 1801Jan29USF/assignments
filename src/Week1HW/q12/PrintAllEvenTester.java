package Week1HW.q12;

/**
 * Functionality: Demonstrates the printing of all even numbers using enhanced for loops
 */
public class PrintAllEvenTester {
    public static void main(String[] args) {
        PrintAllEven pae = new PrintAllEven();
        int[] naturals = new int[100];
        for (int i = 1; i <= 100; i++) {
            naturals[i-1] = i;
        }
        System.out.println(pae.evens(naturals));
    }
}
