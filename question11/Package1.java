package question11;

import java.util.Scanner;

import question11b.Package2;

public class Package1 {

	public static void main(String[] args) {
		Package2 p2 = new Package2();
		Scanner scan = new Scanner(System.in);
		System.out.println("Set the value for float #1");
		float f1 = scan.nextFloat();
		System.out.println("Set the value for float #2");
		float f2 = scan.nextFloat();
		p2.setF1(f1);
		p2.setF2(f2);
		System.out.println(p2.getF1());
		System.out.println(p2.getF2());
	}

}
