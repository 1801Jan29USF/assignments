package Question7;

import java.util.Comparator;

/**
 * For use in comparing two employees by name
 * 
 * @author poblo
 *
 */
class SortByName implements Comparator<Employee> {
	public int compare(Employee a, Employee b) {
		return a.getName().compareTo(b.getName());
	}
}
