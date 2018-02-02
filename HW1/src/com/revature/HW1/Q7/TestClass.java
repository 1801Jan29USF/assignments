package com.revature.HW1.Q7;

import java.util.*;
import com.revature.HW1.Q7.*;

public class TestClass {
	public static void main(String[] args) {

		List<Employee> list = new ArrayList<>(); 
		list.add(new Employee("bob", "sales", 25));
		list.add(new Employee("katie", "analytics", 32));

		System.out.println("Sorting the two employees by age");  //bob is younger, he is first
		list.sort(new AgeComparable());

		System.out.println(list);

		// Iterator<Employee> iter = list.iterator();
		// while(iter.hasNext()) {
		// System.out.println(iter.next());
		// }
		// sorting by name
		list.sort(new NameComparable());
		System.out.println("Sorting list by name."); //bob alphabetically precedes katie
		System.out.println(list);

		list.sort(new DepartmentComparable());
		System.out.println("Sorting list by Department."); // analytics alphabetically precedes sales
		System.out.println(list.toString());

	}
}