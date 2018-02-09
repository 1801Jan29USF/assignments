package Q3;

public class Q3 {
	
	//reverse a string without a temp variable
	public static void main(String[] args) {
		
		String cool = "abcdefg";
		int len = cool.length();
		for(int i = 0; i < len; i++) {
			cool = cool.concat(cool.substring(len - i - 1, len - i));
		}
		cool = cool.substring(len, cool.length());
		System.out.println(cool);
	}
}
