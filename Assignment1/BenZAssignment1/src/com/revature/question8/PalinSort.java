package com.revature.question8;

import java.util.ArrayList;
import java.util.List;

public class PalinSort {
	// reverse the string and compare it to original
	// unless reverse is not on the string pool
	// then intern it first. maybe intern it anyways just for good measure
	public static void main(String[] args) {
		List<String> listOne = new ArrayList<>();
		List<String> listTwo = new ArrayList<>();
		String tmpStr;

		// Is there a better way to do this? very brief internet search said no.
		listOne.add("karan");
		listOne.add("madam");
		listOne.add("torn");
		listOne.add("civic");
		listOne.add("radar");
		listOne.add("sexes");
		listOne.add("jimmy");
		listOne.add("kayak");
		listOne.add("john");
		listOne.add("refer");
		listOne.add("billy");
		listOne.add("did");
		
		// I initialize the stringbuilder within the loop because I wasn't sure how to properly change the value of stringbuilder
		// to another string. There is the replace method but that requires a start and end index. This doesn't make sense if
		// my stringbuilder is not originally initialized to anything, and wouldn't work out if one of the given strings were
		// to be longer than the index I gave. And it might add blank spaces if it were shorter than the index I gave.
		for(String str : listOne) {
			StringBuilder sb = new StringBuilder(str);
			// Need it to be a string so I can use overridden .equals()
			tmpStr = sb.reverse().toString();
			// if(sb.reverse().toString.equals(str)) might also work
			if(tmpStr.equals(str)) {
				listTwo.add(str);
			}
		}

		for(String str : listTwo) {
			System.out.println(str);
		}
		
	}
}
