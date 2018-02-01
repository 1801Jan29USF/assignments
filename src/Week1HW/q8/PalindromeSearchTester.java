package Week1HW.q8;

import java.util.ArrayList;

/**
 * Functionality: Demonstrates the searching for palindromes in a string arraylist.
 */
public class PalindromeSearchTester {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("karan");
        stringArrayList.add("madam");
        stringArrayList.add("tom");
        stringArrayList.add("civic");
        stringArrayList.add("radar");
        stringArrayList.add("sexes");
        stringArrayList.add("jimmy");
        stringArrayList.add("kayak");
        stringArrayList.add("john");
        stringArrayList.add("refer");
        stringArrayList.add("billy");
        stringArrayList.add("did");
        PalindromeSearch ps = new PalindromeSearch();
        ArrayList<String> palindromes = ps.palindromeSearch(stringArrayList);
        System.out.println("Before search: " + stringArrayList);
        System.out.println("After search: " + palindromes);
    }
}
