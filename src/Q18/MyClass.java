package Q18;

public class MyClass extends MyAbstract{
	
	//check for uppercase letters
	public boolean hasUpper(String s) {
		
		return (s != s.toLowerCase());
	}
	//convert string to uppercase
	public String toUpper(String s) {
		
		return s.toUpperCase();
	}
	//convert string to an int and add 10
	public int toInt(String s) {
		
		return s.hashCode() + 10;
	}
}
