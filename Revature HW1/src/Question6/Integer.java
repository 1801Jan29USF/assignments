package Question6;
// Integer without % Question 6 how to determine an integer is even or not
import java.util.*;
public class Integer {

	public static void main(String[] args) {
		
   int X = 0;
  Scanner number = new Scanner(System.in); //obtaining input from the user
  
  System.out.println("Type in an integer to determine if it is even or not");
  X = number.nextInt(); //storing input to a variable
  
  //determining whether the input is even or not by reducing 
  //all to zero except the least significant and check if the result is 0
  if((X & 1) == 0) { 
  System.out.println(X + " is even");
} else {
  System.out.println(X + " is odd");	
}
 number.close(); 
}
}
