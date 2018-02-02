package Question7;

import java.util.ArrayList;
import java.util.Collections;

public class Question7Launcher {
	public static void main(String[] args) {

		ArrayList<Employee> ar = new ArrayList<Employee>();
		ar.add(new Employee(65, " Alfredo ", " Computer Science "));
		ar.add(new Employee(37, " Jack ", " Network Security "));
		ar.add(new Employee(29, " Miguel ", " Information Technology "));

		Collections.sort(ar, new SortByAge());
		System.out.println(" \nSorted by Age ");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		Collections.sort(ar, new SortByName());
		System.out.println(" \nSorted by Name ");
		 for (int i = 0; i < ar.size(); i++)
		 System.out.println(ar.get(i));
		
	   Collections.sort(ar, new SortDepartment());
		System.out.println("\nSorted by Department");
	    for (int i = 0; i < ar.size(); i++)
		 System.out.println(ar.get(i));

	}
}
