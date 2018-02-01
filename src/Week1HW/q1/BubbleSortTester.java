package Week1HW.q1;

import java.util.Arrays;

/**
 * Functionality: Tests the BubbleSort class to demonstrate sorting an array of integers
 */
public class BubbleSortTester {
    public static void main(String[] args) {
        int array[] = {1,0,5,6,3,2,3,7,9,8,4};
        BubbleSort bs = new BubbleSort();
        System.out.println("Before sort: " + Arrays.toString(array));
        array = bs.bubbleSort(array);
        System.out.println("After sort: " + Arrays.toString(array));
    }
}
