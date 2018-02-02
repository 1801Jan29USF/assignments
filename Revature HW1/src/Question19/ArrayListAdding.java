package Question19;

import java.util.ArrayList;

public class ArrayListAdding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>();
	       int X = 0;
	       int Y = 0;
	       //adds into the array 10 integers
	       for(int i = 1; i <= 10; i++) {
	    	   arr.add(i); 
	       }
	       //prints out all the even numbers
	       for(int s = 1; s <= arr.size(); s+=2) {
	    	  X += arr.get(s); 
	       }    
	    	  System.out.println("The sum of all even is " + X);

	       //prints out all the odd numbers
	      for(int t = 0; t < arr.size(); t+=2) {
	    	Y += arr.get(t);
	}
	    	System.out.println("The sum of all odd is " + Y);


}
}