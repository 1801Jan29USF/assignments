package com.revature.comparators;

import java.util.Comparator;

import com.revature.beans.User;

public class UsernameComparator implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		return o1.getUsername().compareTo(o2.getUsername());
	}
}
