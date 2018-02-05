package com.revature.q7;

import java.util.Comparator;

public class SortEmployeeByName implements Comparator<Employee>{

	@Override
	public int compare(Employee emp0, Employee emp1) {
		return emp0.getName().compareTo(emp1.getName());
	}

}
