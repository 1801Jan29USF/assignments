package com.revature.q5;

import java.util.Scanner;

public class SubStringLauncher {
	
	public static void main(String[] args) {
		SubStringer ss = new SubStringer();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string:");
		String str = scan.nextLine(); 
		System.out.println("At what index should the sub stirng end:");
		int idx = scan.nextInt();
		System.out.println(ss.subString(str, idx));
	}

}
