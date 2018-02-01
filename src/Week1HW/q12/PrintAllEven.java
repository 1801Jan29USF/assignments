package Week1HW.q12;

import java.util.ArrayList;

/**
 * Functionality: Implements the printing of all even numbers using enhanced for loops
 */
public class PrintAllEven {
    public ArrayList<Integer> evens(int[] naturals) {
        ArrayList<Integer> toReturn = new ArrayList<>();
        for (int i: naturals) {
            if((i&1)==0){//most reliable and most efficient way to check for parity
                toReturn.add(i);
            }
        }
        return toReturn;
    }
}
