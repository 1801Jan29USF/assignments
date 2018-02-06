package Bank;
import java.io.File;
import java.util.Scanner;






public class UserRegister implements ScreenBank {
	
	private Scanner in = new Scanner(System.in);
	  
	
		@Override
		public ScreenBank prompt() {
			// TODO Auto-generated method stub	
			createFile();
			
			
			return new BankMenu();
		}
			//creates the User Profile,set a password, and enter deposit in the text file
		        public BankMenu createFile() {
		 	
				System.out.println("Welcome New Customer! Please enter the username you want to register:");
				String Username = in.nextLine();
				//gets the user password 
				System.out.println("Now please enter the password you will want on your account:");
				String Password = in.nextLine();
				UserStorage info = new UserStorage(Username, Password);
				UserSerialization us = new UserSerialization();
                File Profile = new File(Username);	
                if (Profile.exists()) {
                	System.out.println("Profile already exist!");
                	return new BankMenu();
                }
                us.SerializerUserCredential(info, Username);
                System.out.println("User Profile has been created. Congratulations!");
				return new BankMenu();
				

		        }
}
	 
					 
		 
