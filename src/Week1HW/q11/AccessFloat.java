package Week1HW.q11;

import Week1HW.q11.b.FloatLocation;

/**
 * Functionality: Accesses two floats from FloatLocation.
 */
public class AccessFloat {
    public static void main(String[] args) {
        FloatLocation fl = new FloatLocation();
        System.out.println("Accessing floats from another package...");
        System.out.println(fl.getA());
        System.out.println(fl.getB());
    }
}
