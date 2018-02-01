package com.revature.question7;

import java.util.ArrayList;
import java.util.List;

public class Question7Complete {
	public static void main(String[] args) {
		
		// Declares an arraylist, adds 4 example employees to it.
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee("Charles", "Testing", 22));
		emp.add(new Employee("Emily", "Development", 20));
		emp.add(new Employee("Sara", "Documentation", 23));
		emp.add(new Employee("Seth", "Programming", 21));
		
		// Using my implemented comparators, prints the employees before any changes are made
		// then again after the list is sorted based on each different category.
		
		System.out.println("The list before I sort based on age: " + emp);
		
		emp.sort(new AgeComparator());
		
		System.out.println("\nThe list after I sort based on age: " + emp);
		
		emp.sort(new NameComparator());
		
		System.out.println("\nThe list after I sort based on name: " + emp);
		
		emp.sort(new DepartmentComparator());
		
		System.out.println("\nThe list after I sort based on department: " + emp);
	}
}