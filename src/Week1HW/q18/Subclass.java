package Week1HW.q18;

/**
 * Functionality: Implements a subclass which extends an abstract superclass.
 */
public class Subclass extends AbstractSuperclass {
    @Override
    boolean checkUppercase(String s) {
        return !s.equals(s.toLowerCase());
    }

    @Override
    String toUppercase(String s) {
        return s.toUpperCase();
    }

    @Override
    void printPlusTen(String s) {
        try{
            System.out.println("10 + " + s + " = " + (10 + Integer.parseInt(s)));
        }
        catch (NumberFormatException e){
            System.out.println("Non-number detected, assuming 0: 10 + 0 = 10");
        }
    }
}
