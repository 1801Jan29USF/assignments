package Q12;

public class Q12 {
	
	//print even numbers 1-100 using enhanced for loop
	public static void main(String[] args) {
		
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		} 
		for (int i : arr) {
			if (i% 2 == 0) {
				System.out.println(i);
			}	
		}
	}
}
