package com.revature.HW1.Q7;
import java.util.Comparator;


/**
 * @author Brandon
 * compareTo() method's result can be used to determine which comes first alphabetically
 *
 */
public class DepartmentComparable implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}

}
