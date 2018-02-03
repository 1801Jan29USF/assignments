package com.revature.compareter;

import java.util.Comparator;

public class sortByDepartment implements Comparator<employee>{
	
	public int compare(employee a, employee b) {
		return a.getDepartment().compareTo(b.getDepartment());
	}

}
