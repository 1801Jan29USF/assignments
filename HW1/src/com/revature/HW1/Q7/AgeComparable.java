package com.revature.HW1.Q7;
import java.util.*;

public class AgeComparable implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		
		return e1.getAge() - e2.getAge(); //Returns whichever age is smallest
	}

}
