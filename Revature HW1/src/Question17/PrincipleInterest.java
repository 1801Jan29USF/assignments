package Question17;
//calculating the interest, principle, and years 
import java.util.Scanner;

public class PrincipleInterest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 double X = 0;
	 double interest = 0;
	 double years = 0;
     Scanner scan = new Scanner(System.in);
     System.out.println("Welcome to our interests calculation: please provide the principle: ");
     X = scan.nextDouble();
     System.out.println("Thank you, now please provide the interest rate given: ");
     interest = scan.nextDouble();
     System.out.println("Thank you, now provide the amount of years of holding the principle: ");
     years = scan.nextDouble();
     System.out.println("Thank you, the following is the principle gain: " + (X * interest * years));
	}

}
