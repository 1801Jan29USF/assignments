package com.revature.HQ7;

public class EmployeeLauncher {

	public static void main(String[] args) {
		Employee E1 = new Employee("Miguel", 21, 'I');
		Employee E2 = new Employee("Jack", 22, 'C');
		
		System.out.println("Sorted by Name: ");
		System.out.println(nameSort(E1,E2));
		System.out.println("Sorted by Age: ");
		System.out.println(ageSort(E1,E2));
		System.out.println("Sorted by Department: ");
		System.out.println(departmentSort(E1,E2));

	}
	
	public static String nameSort(Employee one, Employee two) {
		if(one.name.compareTo(two.name) <= 1) {
			return (one.name.concat(" " + two.name));
		}
		else {
			return two.name.concat(" " + one.name);
		}
	}
	
	public static String ageSort(Employee one, Employee two) {
		if(one.age < two.age) {
			return (one.name.concat(" " + two.name));
		}
		else {
			return two.name.concat(" " + one.name);
		}
	}
	
	public static String departmentSort(Employee one, Employee two) {
		if(one.department < two.department) {
			return (one.name.concat(" " + two.name));
		}
		else {
			return (two.name.concat(" " + one.name));
		}
	}

}
