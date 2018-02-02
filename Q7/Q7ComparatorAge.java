package com.revature.Q7;

import java.util.Comparator;

public class Q7ComparatorAge implements Comparator <Employee> {

	@Override
	public int compare(Employee a, Employee b) {
		// TODO Auto-generated method stub
		return a.getAge() - b.getAge();
	}

}
