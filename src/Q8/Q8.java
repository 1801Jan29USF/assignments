package Q8;

import java.util.ArrayList;
import java.util.Collection;

public class Q8 {
	
	//find all palindromes in a String array
	public static void main(String[] args) {
		
		String[] s = {"karan","madam","tom","civic","radar","sexes","jimmy","kayak","john","refer","billy","did"};
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		
		for (String string : s) {
			a.add(string);
		}
		for (String str : a) {
			boolean flag = true;
			for(int i = 0; i < str.length()/2; i++) {
				if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
					flag = false;
				}
			}
			if(flag) {
				b.add(str);
			}
		}
		for (String string : b) {
			System.out.println(string);
		}
			
	}
}

