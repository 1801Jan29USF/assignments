package Week1HW.q9;

import java.util.ArrayList;
/**
 * Functionality: Implements the searching of prime numbers given an arraylist of integers using eratosthene's sieve
 */
public class PrimeSearch {
    public ArrayList<Integer> primeSearch(ArrayList<Integer> naturals) {
        for(int i=2; i<naturals.size()/2; i++){ //using eratosthenes' sieve method
            for(int j=2*i; j<naturals.get(naturals.size()-1); j+=i){
                naturals.remove(Integer.valueOf(j)); //remove all multiples of i
            }
        }
        return naturals;
    }
}
