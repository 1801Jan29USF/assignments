package Week1HW.q14;

/**
 * Functionality: Demonstrates the usage of a switch.
 */
public class SwitchDemoTester {
    public static void main(String[] args) {
        SwitchDemo sd = new SwitchDemo();

        String cmd = "sqrt";
        System.out.println("sqrt: " + sd.switchDemo(cmd));

        cmd = "date";
        System.out.println("date: " + sd.switchDemo(cmd));

        cmd = "split";
        System.out.println("split" + sd.switchDemo(cmd));
    }
}
