package Week1HW.q8;

import java.util.ArrayList; /**
 * Functionality:
 */
public class PalindromeSearch {
    public ArrayList<String> palindromeSearch(ArrayList<String> stringArrayList) {
        ArrayList<String> toReturn = new ArrayList<>(); //will hold all palindromes
        for (String s: stringArrayList) {
            char[] charArray = s.toCharArray(); //convert to array for easier traversal
            boolean palindrome = true;
            for (int i = 0; i < charArray.length/2; i++) { //only need to iterate over half
                if(charArray[i] != charArray[charArray.length-i-1]){
                    palindrome = false;
                    break; //dont need to continue checking
                }
            }
            if(palindrome)toReturn.add(s);
        }
        return toReturn;
    }
}
