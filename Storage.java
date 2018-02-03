package com.revature.storesnums;
//Q9
import java.util.ArrayList;
import java.util.List;

public class Storage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> n = new ArrayList<Integer>(100);
		for (int i = 1; i <= 100; i++) {
			n.add(i);
			if (i%2!=0) {
				System.out.println(n.get(i-1));
				
			}
			
			
		}
		
		

	}

}
