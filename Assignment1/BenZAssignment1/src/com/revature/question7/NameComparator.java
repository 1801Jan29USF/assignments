package com.revature.question7;

import java.util.Comparator;

public class NameComparator implements Comparator<User>{
	@Override
	public int compare(User user0, User user1) {
		// Messy, but gets the name of string 0 then compares it to the name of string 1
		// Wasn't sure if just subtracting would work
		return user0.getName().compareTo(user1.getName());
	}

}
