package Week1HW.q9;

import java.util.ArrayList;

/**
 * Functionality: Demonstrate the search of prime numbers
 */
public class PrimeSearchTester {
    public static void main(String[] args) {
        ArrayList<Integer> naturals = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            naturals.add(i);
        }
        PrimeSearch ps = new PrimeSearch();
        ArrayList<Integer> primeNaturals = ps.primeSearch(naturals);
        System.out.println("List of primes: " + primeNaturals);
    }

}
