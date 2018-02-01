package com.revature.question7;

import java.util.Comparator;

public class DepartmentComparator implements Comparator<Employee>{

	// One of my overridden Comparator classes. Compares based on Department.
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDepartment().compareTo(o2.getDepartment());
	}
}