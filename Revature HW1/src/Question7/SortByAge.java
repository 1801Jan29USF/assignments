package Question7;

import java.util.Comparator;

public class SortByAge implements Comparator<Employee> {
	// Used for sorting in ascending order by age
	public int compare(Employee a, Employee b) {
		return a.age - b.age;
	}
}
