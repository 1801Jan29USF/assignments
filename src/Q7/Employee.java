package Q7;

//stores an employee
public class Employee {
	
	public int age;
	public String name;
	public String department;
	
	public Employee(int age, String name, String department) {
		super();
		this.age = age;
		this.name = name;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", department=" + department + "]";
	}
	
}
