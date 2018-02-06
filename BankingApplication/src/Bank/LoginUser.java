package Bank;
import java.io.File;
import java.util.Scanner;

public class LoginUser implements ScreenBank {
	private Scanner in = new Scanner(System.in);	
	
	@Override
	public ScreenBank prompt() {
		 UserSerialization us = new UserSerialization();
		 System.out.println("Please enter your username so we can locate your profile:");
		 String Username = in.nextLine();
	     UserStorage CurrentUser;
	     File Profile = new File(Username);	
         if (!Profile.exists()) {
         	System.out.println("Unable to locate your profile. Please try again");
         	return new BankMenu();
         }
         CurrentUser = us.getUser(Username);
         System.out.println("User profile has been located.");
         System.out.println("Please enter your password: ");
	     String Password = in.nextLine(); 
	     
	     if(!Password.equals(CurrentUser.getPassword())) {
	    	 System.out.println("Password is incorrect!");
	    	 return new BankMenu();
	     }
	      System.out.println("Welcome! " + Username);  
			return new MainMenu(CurrentUser);
			
	     
	     
	     
	     
	     
	     
	     
	     
	
         
	     
	     
	     
	     
	}

}



