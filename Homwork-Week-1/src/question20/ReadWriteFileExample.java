package question20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadWriteFileExample {

	public static void main(String[] args) throws IOException {

		// BufferedReader used to help read Data.txt file
		BufferedReader rd = new BufferedReader(new FileReader("Data.txt"));
		String ln;
		// used while loop to read data file and for loop to iterate and read the loine
		// from Data.txt
		// then split the first line read from the file into an array of string.
		// used break to stop the iteration
		while ((ln = rd.readLine()) != null) {

			for (int i = 0; i < ln.length(); i++) {

				String[] st = ln.split(":");
				System.out.println("Name: " + st[0] + " " + st[1]);
				System.out.println("Age: " + st[2] + " years");
				System.out.println("State: " + st[3] + " State\n");
				break;
			}

		}

		rd.close();

	}

}
