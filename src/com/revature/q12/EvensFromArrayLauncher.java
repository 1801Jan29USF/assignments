package com.revature.q12;

import java.util.Scanner;

public class EvensFromArrayLauncher {

	public static void main(String[] args) {

		EvensFromArray efa = new EvensFromArray();
		
		Scanner scan = new Scanner(System.in);
		int first, last;
		System.out.println("Range of numbers:");
		System.out.println("From?");
		first = Integer.parseInt(scan.nextLine());
		System.out.println("To?");
		last = Integer.parseInt(scan.nextLine());
		scan.close();
		int[] intArray = new int[last-first+1];
		for(int i = 0; i < intArray.length; i++) {
			intArray[i] = i+1;
		}
		
		int[] newArray = efa.findEvens(intArray, true);
		for(int num: newArray) {
			System.out.println(num);
		}

	}

}
