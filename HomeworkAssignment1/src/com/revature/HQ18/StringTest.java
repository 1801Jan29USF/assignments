package com.revature.HQ18;

public class StringTest {

	public static void main(String[] args) {
		

		StringWorks sw = new StringWorks();
		
		String t1 = "helloworld";
		String t2 = "HELLOworld";
		String t3 = "10";
		
		System.out.println(sw.uppercase(t1));
		System.out.println(sw.uppercase(t2));
		System.out.println(sw.convert(t2));
		System.out.println(sw.add(t3));

	}

}
