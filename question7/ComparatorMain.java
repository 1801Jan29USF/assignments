package question7;

import java.util.ArrayList;
import java.util.List;

public class ComparatorMain {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Jason", "CEO", 35));
		employees.add(new Employee("Mike", "IT", 24));
		employees.add(new Employee("Adam", "HR", 11));
		employees.add(new Employee("Bruno", "Maintenanc", 50));
		
		employees.sort(new NameComparator());
		//employees.sort(new DepartmentComparator());
		//employees.sort(new AgeComparator());
		
		for(Employee e: employees) {
			System.out.println(e);
		}
		
		
	}

}