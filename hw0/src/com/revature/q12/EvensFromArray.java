package com.revature.q12;

import java.util.ArrayList;
import java.util.List;

public class EvensFromArray {

	public EvensFromArray() {
		super();
	}

	public int[] findEvens(int[] intArray, boolean checkEvens) {
		int[] newArray = new int[intArray.length / 2];
		int i = 0;
		if (checkEvens) {
			for (int num : intArray) {
				if (num % 2 == 0) {
					newArray[i] = num;
					i++;
				}
			}
		} else {
			for (int num : intArray) {
				if (num % 2 != 0) {
					newArray[i] = num;
					i++;
				}
			}
		}

		return newArray;
	}

	public List<Integer> findEvens(List<Integer> intArray, boolean checkEvens) {
		List<Integer> newArray = new ArrayList<>(intArray.size() / 2);
		if (checkEvens) {
			for (int num : intArray) {
				if (num % 2 == 0) {
					newArray.add(num);
				}
			}
		} else {
			for (int num : intArray) {
				if (num % 2 != 0) {
					newArray.add(num);
				}
			}
		}

		return newArray;
	}

	public int sum(int[] intArray, boolean checkEvens) {
		int sum = 0;
		int[] newArray = findEvens(intArray, checkEvens);
		for (int i : newArray)
			sum += i;
		return sum;
	}

	public int sum(List<Integer> intList, boolean checkEvens) {
		int sum = 0;
		List<Integer> newList = findEvens(intList, checkEvens);
		for (int i : newList)
			sum += i;
		return sum;
	}

}
