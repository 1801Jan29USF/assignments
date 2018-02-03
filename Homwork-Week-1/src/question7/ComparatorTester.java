package question7;

import java.util.ArrayList;
import java.util.Collections;

public class ComparatorTester {
	
	public static void main(String[] args) {
		
		ArrayList<ComporataExample> emp = new ArrayList<ComporataExample>();

		emp.add(new ComporataExample("Bob","Math",20));
		emp.add(new ComporataExample("Walter", "Science", 50));
		emp.add(new ComporataExample("Tom", "Health", 22));

		System.out.println("List before Sorting" +emp);
		
		for (int i=0; i<emp.size(); i++){
		System.out.println(emp.get(i));
		}

		System.out.println("\n*********************");  

		System.out.println("Sorted list by name: ");

		Collections.sort(emp, new Name());

		for (int i=0; i<emp.size(); i++){
		System.out.println(emp.get(i));
		}
		
		System.out.println("\n********************"); 
		
		System.out.println("\nSorted list by department: ");

		Collections.sort(emp, new Department());

		for (int i=0; i<emp.size(); i++){
		System.out.println(emp.get(i));

		
		}
		
		System.out.println("***************************");  

		System.out.println("Sorted list by age: ");

		Collections.sort(emp, new Age());

		for (int i=0; i<emp.size(); i++){
		System.out.println(emp.get(i));

		}
		
	}
	
	

}
