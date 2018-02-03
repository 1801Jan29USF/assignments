package question12;

public class ArrayUsingFoorLoop {

	public static void main(String[] args) {
		
		int[] array = new int[100];
		
		//Storing 1 to 100 in Array
		for(int i = 1; i <= 100; i++) {			
			array[i-1] = i;
		}
		
		//Showing Even Number using For Each Loop
		for(int i: array) 
			if(i % 2 == 0)
				
		
		System.out.println(i);
			
		
		}
		
		

	

}
