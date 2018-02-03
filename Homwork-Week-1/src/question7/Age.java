package question7;

import java.util.Comparator;

public class Age implements Comparator<ComporataExample> {

	@Override
	public int compare(ComporataExample o1, ComporataExample o2) {
		
		return o1.getAge() - o2.getAge();
	}

}
