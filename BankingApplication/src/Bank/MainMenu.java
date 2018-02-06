package Bank;
import java.util.Scanner;



public class MainMenu implements ScreenBank {  
	private UserSerialization us = new UserSerialization();
	UserStorage User;
	Scanner input = new Scanner(System.in);


	public MainMenu(UserStorage CurrentUser) {
		// TODO Auto-generated constructor stub
		this.User = CurrentUser;
	}


	@Override
	public ScreenBank prompt() {
		// TODO Auto-generated method stub
	  System.out.printf("Welcome! What would you like to do? Type B for balance W for withdraw D for deposit T for transaction history or E to logout");
	  String u = input.nextLine();
	  switch(u) {
	  
	  case "B":
		System.out.println("Your current balance is: " + this.User.getBalance());
		  break;
		  
	  case "W":
		  System.out.println("How much do you want to withdraw? " + "Current balance is " + this.User.getBalance());
		  String w = input.nextLine();
          Double withdraw = Double.parseDouble(w);
	        if(this.User.getBalance() >= withdraw && withdraw >= 0) {
	            this.User.setBalance(this.User.getBalance() - withdraw);
			System.out.println("Your bank total is now: " +this.User.getBalance()); 			
	        } else {
	        System.out.println("Sorry, you have insufficient funds available " + this.User.getBalance());
	        }
	        this.User.addTransaction("You withdraw " + withdraw, null);
	        us.SerializerUserCredential(User, this.User.getUsername());
		 break;
		 
	  case "D":
		   System.out.println("How much do you want to deposit? " + "Current balance is: " + this.User.getBalance());
		   String deposit = input.nextLine();
           Double total = Double.parseDouble(deposit);
           us.SerializerUserCredential(User ,this.User.getUsername() );
           this.User.addTransaction("You deposited " + total, null);
		   if (total >= 0) {
			this.User.setBalance(this.User.getBalance() + total);  
			System.out.println("Your bank total is now: " +this.User.getBalance());  
		   }  
		us.SerializerUserCredential(User, this.User.getUsername());
		break;
	  case "T":	
		  System.out.println();
		  this.User.Transaction();	  	  
		  System.out.println();
		  
		  break;
	  case "E":
		  System.out.println("Thank you come again! " + this.User.getUsername());
		  
		  
		  return new BankMenu();
	      
		  
	  }
	return new MainMenu(this.User);	
	}

}
