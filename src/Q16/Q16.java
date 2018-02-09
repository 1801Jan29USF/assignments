package Q16;

public class Q16 {
	
	//read a string from command line and determine length
	public static void main(String[] args) {
		
		int sum = -1;
		for (String string : args) {
			sum += string.length() + 1;
		}
		System.out.println(sum);
	}
}
