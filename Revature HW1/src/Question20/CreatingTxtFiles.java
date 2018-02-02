package Question20;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class CreatingTxtFiles {
	public static void main(String[] args) {
		ArrayList<Info> ppl = new ArrayList<>();
		
		Scanner scan = null;
		try {
		scan = new Scanner(new File("src/Question20/Data.txt"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		//if the line is not empty then get the text from each line until is empty
		if (scan != null) {
			while(scan.hasNext()) {
				ppl.add(new Info(scan.nextLine()));
			}
		}
		//read the lines. ppl the array list where the text info is stored. 
		for ( Info i:ppl) {
			System.out.println(i);
			System.out.println();
		}

	}

}
