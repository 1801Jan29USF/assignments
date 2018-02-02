package com.revature.question7;

import java.util.ArrayList;
import java.util.List;

public class ComparatorLauncher {
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		users.add(new User("qwert", "lame", 2599));
		users.add(new User("asdfg", "short", 29));
		users.add(new User("zxcvb", "special", 420));
		users.add(new User(";lkjh", "righthand", 001));
		
		// Maybe these should be in a method that takes in a ...comparator? generic?
		System.out.println("Sorting by age.");
		users.sort(new AgeComparator());
		for(User u : users) {
			System.out.println(u);
		}
		System.out.println("Sorting by name");
		users.sort(new NameComparator());
		for(User u : users) {
			System.out.println(u);
		}
		System.out.println("Sorting by department");
		users.sort(new DeptComparator());
		for(User u : users) {
			System.out.println(u);
		}
	}
}
