package question7;

import java.util.Comparator;

public class Name implements Comparator<ComporataExample>{

	@Override
	public int compare(ComporataExample o1, ComporataExample o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
