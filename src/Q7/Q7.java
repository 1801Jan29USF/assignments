package Q7;

import java.util.ArrayList;
import java.util.List;

public class Q7 {
	//Test my comparator
		public static void main(String[] args) {
			
			Employee e = new Employee(26, "Matt", "Sit");
			Employee t = new Employee(26, "Matt", "Sales");
			List<Employee> list = new ArrayList<>();
			list.add(e);
			list.add(t);
			System.out.println(list);
			list.sort(new AgeComparator());
			System.out.println(list);
		}
}
