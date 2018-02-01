package com.revature.question7;

import java.util.Comparator;

public class NameComparator implements Comparator<Employee>{

	// One of my overridden Comparator classes. Compares based on Name.
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
}