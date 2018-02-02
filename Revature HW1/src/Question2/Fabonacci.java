package Question2;
//Fabonacci Question 2
public class Fabonacci {

	public static void main(String[] args) {
		   int a = 0, b = 0, c = 1;  
		   for(int i = 1; i <= 25; i++) {
			 
			  a = b;
			  b = c;
			  c = a + b;
			  System.out.println(a + "");
	}

}
}
