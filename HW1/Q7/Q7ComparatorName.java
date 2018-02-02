package com.revature.Q7;

import java.util.Comparator;

public class Q7ComparatorName implements Comparator <Employee> {

	@Override
	public int compare(Employee a, Employee b) {
		// TODO Auto-generated method stub
		return a.getName().hashCode() - b.getName().hashCode();
	}

}
