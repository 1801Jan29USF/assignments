package question7;

import java.util.Comparator;

public class Department implements Comparator<ComporataExample> {

	@Override
	public int compare(ComporataExample o1, ComporataExample o2) {
		
		return o1.getDepartment().compareTo(o2.getDepartment());
	}

}
