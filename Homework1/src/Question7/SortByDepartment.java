package Question7;

import java.util.Comparator;

/**
 * For use in comparing two employees by department
 * 
 * @author poblo
 *
 */
class SortByDepartment implements Comparator<Employee> {
	public int compare(Employee a, Employee b) {
		return a.getDepartment().compareTo(b.getDepartment());
	}
}
