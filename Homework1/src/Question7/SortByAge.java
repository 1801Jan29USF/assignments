package Question7;

import java.util.Comparator;

/**
 * Fore use in comparing two employees by age
 * 
 * @author poblo
 *
 */
class SortByAge implements Comparator<Employee> {
	public int compare(Employee a, Employee b) {
		return a.getAge() - b.getAge();
	}
}
