package Question11;

/* gives the program access to the variables stored within class VariableHolder
 *  in package Question11Helper
 */
import Question11Helper.VariableHolder;

public class Q11Launcher {

	public static void main(String[] args) {
		// Prints out the values of variables from another class and package
		System.out.println(VariableHolder.varA);
		System.out.println(VariableHolder.varB);
	}

}
