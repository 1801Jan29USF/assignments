package Week1HW.q14;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Functionality: Implements a switch
 */
public class SwitchDemo {
    public Object switchDemo(String s){
        switch (s){
            case "sqrt"://returns square root of number
                return Math.sqrt(2);
            case "date"://returns current date and time
                return Calendar.getInstance().getTime().toString();
            case "split"://returns a split string
                String[] split = "I am learning Core Java".split(" ");
                return Arrays.toString(split);
            default:
                return null; //breaks are not necessary due to return statements
        }
    }
}
