package com.revature.HW1.Q7;
/**
 * @author Brandon
 * compareTo() contains name, age and department fields, as well as all necessary methods
 *
 */
public class Employee {
	
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	private String department;
	private String name;
	@Override
	public String toString() {
		return "Employee [department=" + department + ", name=" + name + ", age=" + age + "]";
	}
	private int age;
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
}
