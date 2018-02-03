package question3;

public class ReverseString {
	
	private StringBuffer originalString;
	private StringBuilder newString;
	private String original;
	private int length;
	
	public ReverseString() {
		newString = new StringBuilder();
	}
	
	public void setString(String s) {
		original = s;
		length = s.length();
	}
	
	public void reverseString() {
		originalString = new StringBuffer(original);
		for(int i = 0; i < original.length(); i++) {
			newString.append(originalString.charAt(length - (i + 1)));
		}
	}
	
	public void printNewString() {
		System.out.println(newString.toString());
	}
}
