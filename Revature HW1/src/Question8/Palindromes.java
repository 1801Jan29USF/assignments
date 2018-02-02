package Question8;
//Pulling out Palindromes from a list of arrays and reversing them
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindromes {

	public static void main(String[] args) {
	
		String[] arr = {"karan","madam","tom","civic","radar","sexes","jimmy","kayak", "did","john","refer", "billy"}; // this is the preset Arrays to find Palindromes
		String[] res = palind(arr); //this is the code where the Palindromes are stored in res
    	System.out.println(java.util.Arrays.toString(res)); //this is where res is being displayed in the console
		}

		public static String[] palind(String[] arr){
		    int count = 0;
		    java.util.ArrayList<String> list = new java.util.ArrayList<String>(); 
		    for(String s : arr){
		            if(isPalindrome(s) == true){
		                count++;
		                list.add(s);
		            }
		        }
		    String[] a = list.toArray(new String[count]);
		    return a;
	}

		public static boolean isPalindrome(String s){
		 return s.equals(new StringBuilder(s).reverse().toString());
	}
}
