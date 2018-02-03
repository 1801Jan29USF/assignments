package question8;

import java.util.LinkedList;
import java.util.List;

public class Palindromes {
	
	private List<String> palindromes;
	private List<String> newList;
	
	public Palindromes() {
		super();
	}

	public void findPalindromes(List<String> s) {
		
		List<String> strings = new LinkedList<>();
		palindromes = new LinkedList<>();
		newList = new LinkedList<>();
		strings = s;
		for(String st: strings) {
			StringBuilder sb = new StringBuilder(st);
			String rev = sb.reverse().toString();
			String str = sb.toString();
			if(rev.equals(str)) {
				palindromes.add(sb.toString());
			} else {
				newList.add(sb.toString());
			}
		}
	}
	
	public void printLists() {
		System.out.println("The palindromes are:");
		for(String s: palindromes) {
			System.out.println(s);
		}
		System.out.println("The other strings are:");
		for(String os: newList) {
			System.out.println(os);
		}
	}

}
