package Bank;
import java.util.Scanner;



public class BankMenu implements ScreenBank {
	private Scanner scan = new Scanner(System.in);

	public ScreenBank prompt() {
		System.out.println("Welcome to IBM Bank. Please select one of the following:");
		System.out.println("Press 1 If you are a new user");
		System.out.println("Press 2 If you are a registered user");
		String input = scan.nextLine();
			
		switch(input) {
		case "1":
			//goes to the UserRegister class where the user is prompted to create a profile
			return new UserRegister();
		case "2":
			//goes to the UserLogin class where the user is prompted to log in to their file
			return new LoginUser();
		default:
			System.out.println("Sorry, you pressed an invalid option. Try again");
			break;
		
		}
		return new BankMenu();
}
}
