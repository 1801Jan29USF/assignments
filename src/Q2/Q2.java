package Q2;

public class Q2 {
	
	//output the first 25 fibonacci numbers, beginning with 0
	public static void main(String[] args) {
		
		int b = 0;
		System.out.println(1 + " " + b);
		int a = 1;
		System.out.println(2 + " " + a);
		int temp;
		for(int i = 3; i < 26; i++) {
			temp = a;
			a = a + b;	
			b = temp;
			System.out.println(i + " " + a);
		}
		
	}
}
