package com.revature.question7;

import java.util.Comparator;

public class DeptComparator implements Comparator<User>{
	@Override
	public int compare(User user0, User user1) {
		// Messy, but gets the name of string 0 then compares it (lexicographically) to the name of string 1
		// Wasn't sure if just subtracting would work
		return user0.getDepartment().compareTo(user1.getDepartment());
	}

}
