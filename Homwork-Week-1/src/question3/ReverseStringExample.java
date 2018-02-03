package question3;

public class ReverseStringExample {

	public static void main(String[] args) {
		
		String x= "Revature";
		
		//converted stirng int CharArray to be able to reverse the sinput
		char[] input = x.toCharArray();
		
		//used a loop to iterate and print out charcters in reverse order
		for(int i = input.length-1; i >= 0; i--) {
			System.out.println(input[i]);
		}
		
		

	}

}
