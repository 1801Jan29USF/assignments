package Week1HW.q19;

import java.util.ArrayList;

/**
 * Functionality: Demonstrates the functionality of an ArrayList.
 */
public class ArrayListDemoTester {
    public static void main(String[] args) {
        ArrayList<Integer> naturals = new ArrayList<>();
        for (int i = 1; i <= 10 ; i++) {
            naturals.add(i);
        }
        ArrayListDemo ald = new ArrayListDemo();
        System.out.println("All numbers: " + naturals);
        System.out.println("Sum of evens: " + ald.addEvens(naturals));
        System.out.println("Sum of odds: " + ald.addOdds(naturals));
        naturals = ald.removePrimes(naturals);
        System.out.println("All composite numbers: " + naturals);
    }
}
