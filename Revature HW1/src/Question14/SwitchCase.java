package Question14;
import java.math.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class SwitchCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Scanner scan = new Scanner(System.in);
			System.out.println("Please select an option: ");
			System.out.println("Enter 1 to find the square root of a Number");
			System.out.println("Enter 2 to display today's date");
			System.out.println("Enter 3 split an Array");
			String input = scan.nextLine();

			switch (input) {
			case "1":
				//Finding the Square Root of a Number
				 System.out.print("type a number to find the square root");
				 int X = scan.nextInt();
			     System.out.println(Math.sqrt(X));
				break;
			case "2":
				// Displaying Current Day
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				System.out.println(dateFormat.format(date));
				break;
			case "3":
				//Splitting an array
				String str = "I am learning Core Java";
				String[] res = str.split("");
				System.out.println(res[3]);
				break;

			default:
				System.out.println("invalid option");
				break;
			}
	}

}
