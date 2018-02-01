package Week1HW.q3;

/**
 * Functionality: Implements the reversal of strings without temporary values or StringBuffer/StringBuilder APIs.
 */
public class ReverseString {
    String reverseString(String str){
        for (int i = 0; i < str.length(); i++) {//functionally a while loop as the string length increases over time
            try{
                //traverse the string backwards and append to it character by character
                str += str.substring(str.length()-(2*i)-1, str.length()-(2*i));
            }catch(StringIndexOutOfBoundsException e){ //if we reach the end of the string
                str = str.substring(str.length()/2); //remove the original section of the string
                break; //break out of the loop
            }
        }
        return str;
    }
}
