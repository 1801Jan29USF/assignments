package question2;

public class FibonacciExample {
	
	public static void main(String[] args) {
		
		//using fibonacci series to display the first 25 numbers starting from 0
		
		int n1 = 0, n2= 1, n3, i, count = 25;
		
		System.out.println(n1);//printing 0
		System.out.println(n2);//printing 1
		
		for(i =2; i < count; i++ ) { // loop starts from 2 because 0 is already printed
			n3 = n1+n2;
			System.out.println( n3);
			
			n1=n2;
			n2=n3;
			
		}
		
	}
	
	
	
	

}
