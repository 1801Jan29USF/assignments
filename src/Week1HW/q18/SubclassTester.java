package Week1HW.q18;

/**
 * Functionality: Demonstrates the functionality of the subclass which implements an abstract superclass.
 */
public class SubclassTester {
    public static void main(String[] args) {
        Subclass sc = new Subclass();
        System.out.println("Does 'am i too loud' have uppercase characters? It does " + (sc.checkUppercase("am i too loud?") ? "" : "not"));
        sc.printPlusTen("39");
        System.out.println("Setting 'im too quiet' to all uppercase: " + sc.toUppercase("im too quiet"));
    }
}
