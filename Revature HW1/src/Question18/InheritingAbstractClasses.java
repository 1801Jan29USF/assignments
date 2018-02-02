package Question18;
import Question18.*;


public class InheritingAbstractClasses extends Abmethod {

	//checks for uppercase and returns true or false if the string has uppercase
	@Override
	boolean checkupcase(String a) {
		// TODO Auto-generated method stub
		return !a.equals(a.toLowerCase());
	}
// makes the string all uppercase letters
	@Override
	String uppercase(String b) {
		// TODO Auto-generated method stub
		return b.toUpperCase();
	}
	
//parseint and adds 10 
	@Override
	void converter(String c) {
		// TODO Auto-generated method stub
		
		System.out.println("10 + " + c + " = " + (10 + Integer.parseInt(c)));
		
	
	}

	
	
}
