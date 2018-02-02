package Q20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q20 {
	//reads a file in the specified format and prints it in a new format
	public static void main(String[] args) {
		File f = new File("src/com/revature/com/revature/Q20/Data.txt");
		Scanner sc;
		try {
			sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String s;
				String[] a;
				s = sc.nextLine();
				a = s.split(":");
				System.out.println("Name: " + a[0] + " " + a[1] + "\nAge: " + a[2] + " years\nState: " + a[3] + " State\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
