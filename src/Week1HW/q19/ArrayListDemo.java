package Week1HW.q19;

import java.util.ArrayList;
/**
 * Functionality: Implements three functions to demonstrate the ArrayList.
 */
public class ArrayListDemo {
    public int addEvens(ArrayList<Integer> naturals) {
        int sum = 0;
        for (Integer natural : naturals) {
            if ((natural & 1) == 0) sum += natural;
        }
        return sum;
    }

    public int addOdds(ArrayList<Integer> naturals) {
        int sum = 0;
        for (Integer natural : naturals) {
            if ((natural & 1) != 0) sum += natural;
        }
        return sum;
    }

    public ArrayList<Integer> removePrimes(ArrayList<Integer> naturals) {
        ArrayList<Integer> oldCopy = (ArrayList<Integer>) naturals.clone();
        for(int i=2; i<naturals.size()/2; i++){ //using eratosthenes' sieve method to find primes
            for(int j=2*i; j<naturals.get(naturals.size()-1); j+=i){
                naturals.remove(Integer.valueOf(j)); //remove all multiples of i
            }
        }
        oldCopy.removeAll(naturals); //naturals now only contains primes
        return oldCopy;
    }
}
