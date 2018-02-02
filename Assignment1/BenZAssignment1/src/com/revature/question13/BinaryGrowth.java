package com.revature.question13;

public class BinaryGrowth {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int toggle = 0;
		
		for(int i = 0; i < 10; i++) {
			if (toggle == 0) {
				sb.append("0");
				toggle = 1;
			}
			else {
				sb.append("1");
				toggle = 0;
			}
			System.out.println(sb);
		}
		
//		// Alternatively
//		for(int i = 0; i < 10; i++) {
//			sb.append("0");
//			System.out.println(sb);
//			sb.append("1");
//			System.out.println(sb);
//		}

	}
}
