package com.revature.question7;

import java.util.Comparator;

public class AgeComparator implements Comparator<Employee>{

	// One of my overridden Comparator classes. Compares based on Age.
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getAge() - o2.getAge();
	}
}