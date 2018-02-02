package Question1;

import java.util.Arrays;

public class Q1Launcher {

	/*
	 * Sorts an array of integers by switching each number with that on its right if
	 * and only if it is larger than its counterpart. Iterates to completion.
	 */
	public static int[] bubbleSort(int[] subject) {
		int l = subject.length;
		int[] sorted = subject;
		int temp;
		/*
		 * The maximum number of iterations necessary is the smallest number of
		 * movements required to move the rightmost number to the leftmost slot. So, the
		 * length of the array -1.
		 */
		for (int i = 0; i < l; i++) {
			/*
			 * Sweeps through the array left to right, switching each number with the one on
			 * its right if that number is smaller
			 */
			for (int j = 0; j < l - 1; j++) {
				if (sorted[j] > sorted[j + 1]) {
					temp = sorted[j];
					sorted[j] = sorted[j + 1];
					sorted[j + 1] = temp;
				}
			}
		}
		return sorted;
	}

	public static void main(String[] args) {
		int[] givenArray = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int[] sortedArray = bubbleSort(givenArray);
		System.out.println(Arrays.toString(sortedArray));
	}

}
