package com.revature.q7;

import java.util.ArrayList;
import java.util.Collections;

public class SortEmployeeLauncher {
	
	public static void main(String[] args) {
		Employee emp0 = new Employee("Bobby", "IT", 25);
		Employee emp1 = new Employee("Billy", "Sales", 25);
		
		ArrayList<Employee> empArray = new ArrayList<Employee>();
		empArray.add(emp0);
		empArray.add(emp1);
		int len = empArray.size();
		
		// sort by name
		System.out.println("Sort by name:");
		Collections.sort(empArray, new SortEmployeeByName());
		for (int i = 0; i < len; i++) {
			System.out.println(empArray.get(i));
		}
		
		// sort by dept
		System.out.println("Sort by dept:");
		Collections.sort(empArray, new SortEmployeeByDept());
		for (int i = 0; i < len; i++) {
			System.out.println(empArray.get(i));
		}
		
		// sort by age
		System.out.println("Sort by age:");
		Collections.sort(empArray, new SortEmployeeByAge());
		for (int i = 0; i < len; i++) {
			System.out.println(empArray.get(i));
		}
	}

}
