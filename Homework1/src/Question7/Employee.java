package Question7;

/**
 * Represents an employee with a name, department, and age
 * 
 * @author poblo
 *
 */
public class Employee {
	private String name;
	private String department;
	private int age;

	public Employee(String handle, String depo, int years) {
		this.name = handle;
		this.department = depo;
		this.age = years;
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

}
