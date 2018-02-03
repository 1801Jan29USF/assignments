package com.revature.compareter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		List<employee> e = new ArrayList<>();
		e.add(new employee("Denis", "I.T",25));
		e.add(new employee("An'Draya", "Human Resources",30));
		e.add(new employee("Sam", "Cafe", 21));
		Collections.sort(e);
		
		System.out.println("List of employees by age");
		Iterator<employee> iterate = e.iterator();
		while(iterate.hasNext()) {
			System.out.println(iterate.next());
		}
		e.sort(new sortByName());
		System.out.println("List of employees by name");
		Iterator<employee> iterate2 = e.iterator();
		while(iterate2.hasNext()) {
			System.out.println(iterate2.next());
		}
		
		
		
			
		
		e.sort(new sortByDepartment());
		System.out.println("List of employees by department");
		Iterator<employee> iterates = e.iterator();
		while(iterates.hasNext()) {
			System.out.println(iterates.next());
			
		}
		
		
		
		
		
	}

}
