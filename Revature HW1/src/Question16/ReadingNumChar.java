package Question16;
import java.util.Scanner;
public class ReadingNumChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner scan = new Scanner(System.in);
       System.out.println("Hello, please type in the amount of characters you want counted: ");
       String input = scan.nextLine();
       
       //Loop to count the amount of characters inputted from the user
       int counter = 0;
       for( int i=0; i<input.length(); i++ ) {
       counter++;  
	}
     System.out.println(counter); 
	}
}
