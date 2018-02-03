package question16;

public class StringInputExample {

	public static void main(String[] args) {
		
		//Used enhanced for loop to iterate through command line arrgument, and used
		//.length method to display the number of characters
		for(String s: args) {
			System.out.println("This is the number of characters for the string input " + s.length());
		}

	}

}
