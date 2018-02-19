package com.revature.question7;

import java.util.Comparator;

public class AgeComparator implements Comparator<User>{

	@Override
	public int compare(User user0, User user1) {
		return user0.getAge() - user1.getAge();
	}
	

}
