package Week1HW.q13;

/**
 * Functionality: Demonstrates the creation of the desired triangle
 */
public class BinaryTriangleTester {
    public static void main(String[] args) {
        //desired triangle, without newlines, is simply a string of 0s and 1s alternating.
        BinaryTriangle bt = new BinaryTriangle();
        bt.generateTriangle(4);
    }
}
