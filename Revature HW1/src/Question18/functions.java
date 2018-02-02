package Question18;
import Question18.Abmethod;
import Question18.InheritingAbstractClasses;

public class functions {
	
	public static void main(String[] args) {
		// creates an abstract variable where the string can be checked
		InheritingAbstractClasses ab = new InheritingAbstractClasses();
		

	   
	    System.out.println("Do i have uppercase letters? " + (ab.checkupcase("Do i have Uppercase lettErs?") ? "Yes":"No"));
	    System.out.println("make me all uppercase letters " + (ab.uppercase(" make me all uppercase letters")));
	    ab.converter("20");
	}

	
	
}
