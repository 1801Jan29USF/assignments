package Question15;
import java.util.Scanner;
public class Operate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int one = 0;
		int two = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose a number you want to find the operation: ");
		one = scan.nextInt();
		System.out.println("Choose another number you want to find the operation: ");
		two = scan.nextInt();
		
		Operands srs = new Operands();
		
		System.out.println("This is the Addition " + srs.add(one, two));
		System.out.println("This is the Substraction " + srs.subtract(one, two));
		System.out.println("This is the Multiplication " + srs.multiply(one, two));
		System.out.println("This is the Division " + srs.divide(one, two));



	}

}
