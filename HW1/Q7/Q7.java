package com.revature.Q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparator <Employee> {
	
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int compare(Employee a, Employee b) {
		// TODO Auto-generated method stub
		return a.getAge()- b.getAge();
	}
	
	private String name;
	private String department;
	private int age;
	
	static void main(String[] args) {
		Employee e1 = new Employee("Jack", "Physics", 23);
		Employee e2 = new Employee("Jill", "Math", 32);
		
		ArrayList <Employee> arr = new ArrayList<>();
		arr.add(e1);
		arr.add(e2);
		
		Collections.sort(arr, new Q7ComparatorAge());
		Collections.sort(arr, new Q7ComparatorDepart());
		Collections.sort(arr, new Q7ComparatorName());
		
		
		
	
	}
}
