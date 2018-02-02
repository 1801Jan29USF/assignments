package Question7;

public class Employee {
	 
	 int age; 
	 String name, department;
	
	//Constructor
	public Employee(int age,  String name, String department){
	
	this.age = age;
	this.name= name;
	this.department = department;
	}
	//Used to print details of the employee
	public String toString() {
		return this.age + "" + this.name + "" + this.department;
	}
}