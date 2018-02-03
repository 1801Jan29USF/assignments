package question6;

public class EvenIntegerExample {
	
	private void isEven(int i) {
		if((i/2)* 2== i) {
			System.out.println(i + " is an Even number");
		}else {
			System.out.println(i + " is not an even number");
		}
	}

	public static void main(String[] args) {

		EvenIntegerExample x = new EvenIntegerExample();
		EvenIntegerExample y = new EvenIntegerExample();
		EvenIntegerExample z = new EvenIntegerExample();
		
		x.isEven(10);
		y.isEven(25);
		z.isEven(346);
		

	}

}
