//Q3
package com.revature.reverse;

public class reverseString {
	static int i;
	static void stringreverse(String s) {
		//char ch[]= new char[s.length()];
		char ch[];
		ch = s.toCharArray();
		for ( i = s.length()-1; i >= 0; i--) {
			System.out.print(ch[i]);
			}
		
			
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stringreverse("Core Java is ok with me");
	}

}
