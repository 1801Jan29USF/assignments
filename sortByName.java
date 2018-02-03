package com.revature.compareter;

import java.util.Comparator;

public class sortByName  implements Comparator<employee>{
	public int compare(employee a, employee b) {
		return a.name.compareTo(b.name);
		
	}
	
	

}
