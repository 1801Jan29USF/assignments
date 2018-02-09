package Q7;

import java.util.Comparator;

//comparator for the employee class
public class AgeComparator implements Comparator<Employee> {
	
	@Override
	public int compare(Employee arg0, Employee arg1) {
		// TODO Auto-generated method stub
		if(arg0.age - arg1.age != 0) {
			return arg0.age - arg1.age;
		}
		else if(!arg0.name.equals(arg1.name)) {
			return arg0.name.compareTo(arg1.name);
		}
		else if(!arg0.department.equals(arg1.department)) {
			return arg0.department.compareTo(arg1.department);
		}
		else {
			return 0;
		}
	}

}
