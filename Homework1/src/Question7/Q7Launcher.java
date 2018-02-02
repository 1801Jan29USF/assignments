package Question7;

import java.util.ArrayList;
import java.util.Collections;

public class Q7Launcher {

	public static void main(String[] args) {

		// Creates an arraylist containing two sample employees
		ArrayList<Employee> twoEmployees = new ArrayList<Employee>();
		twoEmployees.add(new Employee("Karen", "Sales", 36));
		twoEmployees.add(new Employee("Frank", "HR", 42));

		// Prints the employees by name in their initial order
		System.out.println(twoEmployees.get(0).getName());
		System.out.println(twoEmployees.get(1).getName());
		System.out.println();

		// Sorts employees alphabetically by name
		Collections.sort(twoEmployees, new SortByName());

		// Prints employees by name in new order. Karen and Frank have switched.
		System.out.println(twoEmployees.get(0).getName());
		System.out.println(twoEmployees.get(1).getName());
		System.out.println();

		// Sorts employees numerically by age. Karen and Frank switch
		Collections.sort(twoEmployees, new SortByAge());

		// Prints employees alphabetically by department
		System.out.println(twoEmployees.get(0).getDepartment());
		System.out.println(twoEmployees.get(1).getDepartment());
		System.out.println();

		// Sorts employees alphabetically by department. Karen and frank switch
		Collections.sort(twoEmployees, new SortByDepartment());

		// Prints employees alphabetically by department
		System.out.println(twoEmployees.get(0).getDepartment());
		System.out.println(twoEmployees.get(1).getDepartment());
		System.out.println();

		// Prints employees numerically by age
		System.out.println(twoEmployees.get(0).getAge());
		System.out.println(twoEmployees.get(1).getAge());
		System.out.println();

		// Sorts employees numerically by age. Karen and Frank switch
		Collections.sort(twoEmployees, new SortByAge());

		// Prints employees numerically by age
		System.out.println(twoEmployees.get(0).getAge());
		System.out.println(twoEmployees.get(1).getAge());
		System.out.println();

	}

}
