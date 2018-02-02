package com.revature.Q07;

import java.util.ArrayList;
import java.util.Comparator;

public class EmployeeSort implements Comparator<Employee> {

	public static void main(String[] args) {

		Employee e1 = new Employee("Rick", "IT", 26);
		Employee e2 = new Employee("Adam", "IT", 28);
		Employee e3 = new Employee("Rick", "Computer Science", 30);
		Employee e4 = new Employee("Rick", "IT", 29);
		Employee e5 = new Employee("Rick", "IT", 29);
		ArrayList<Employee> aL = new ArrayList<Employee>();
		aL.add(e1);
		aL.add(e2);
		aL.add(e3);
		aL.add(e4);
		aL.add(e5);
		EmployeeSort comp = new EmployeeSort();
		aL.sort(comp);
		for (Employee str : aL) {
			System.out.println(str);
		}

	}

	@Override
	public int compare(Employee e1, Employee e2) {
		// Compares names and if equal moves on to department
		if (e1.getName().compareTo(e2.getName()) == 0) {
			// Compares departments and if equal moves on to age
			if (e1.getDepartment().compareTo(e2.getDepartment()) == 0) {
				// Compares age
				return Integer.compare(e1.getAge(), e2.getAge());
			}
			// Compare by department if name is equal
			return e1.getDepartment().compareTo(e2.getDepartment());
		}
		// Compare by names
		return e1.getName().compareTo(e2.getName());
	}

}
