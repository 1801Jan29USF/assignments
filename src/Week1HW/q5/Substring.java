package Week1HW.q5;

/**
 * Functionality: Implements the creation of a substring without using existing substring creation tools.
 */
public class Substring {
    String substring(String str, int index){
        char stringArray[] = str.toCharArray();
        String s = "";
        for(int i=0; i<index; i++){ //iterates over the existing string to add selected characters to an empty string
            s += stringArray[i]; //ideally this is a StringBuilder
        }
        return s;
    }
}
