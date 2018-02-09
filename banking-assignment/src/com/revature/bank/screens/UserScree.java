package com.revature.bank.screens;

import java.util.Scanner;

import com.revature.bank.bean.User;
import com.revature.bank.utility.BankSerializer;

/**
 * User Screen is the where a user is able to view balance, deposit, and withdaw from account.
 * The user is able to use this screen as long as they are logged on. At the end of 
 * each activity, the user returns to this screen. Once the user logs off, they return to 
 * main menu
 * 
 * @author Ahmed
 *
 */
public class UserScree implements Screen {

	User user;

	public UserScree(User user) {

		this.user = user;
	}

	private Scanner scan = new Scanner(System.in);
	private BankSerializer bs = new BankSerializer();

	@SuppressWarnings("null")
	@Override
	public Screen prompt() {
		System.out.println("Please select an option.");
		System.out.println("Enter 1 to Veiw your Balance");
		System.out.println("Enter 2 to make a deposit");
		System.out.println("Enter 3 to withdraw");
		System.out.println("Enter 4 to log out");

		String input = scan.nextLine();

		switch (input) {
		case "1":

			System.out.println("Your current balance is $" + user.getBalance());

			return new UserScree(user);

		case "2":

			System.out.println("Please amount you want to deposit");
			double amountD = Double.parseDouble(scan.nextLine());
			if (amountD >= 0) {
				user.deposit(amountD);
			}
			bs.SerilaziableBank(user, user.getUserName());
			System.out.println("You have susccessfully made a deposit");
			System.out.println("Your new balance is $" + user.getBalance());
			return new UserScree(user);

		case "3":

			System.out.println("Please amount you want you want to withdraw");

			double amountW = Double.parseDouble(scan.nextLine());
			if (amountW >= user.getBalance()) {
				System.out.println("You have insufficiant fund.");
				return new UserScree(user);
			} else {

				user.withdraw(amountW);
				bs.SerilaziableBank(user, user.getUserName());
				System.out.println("You have susccessfully made a withdrawl");
				System.out.println("Your new balance is $" + user.getBalance());
				return new UserScree(user);
			}

		case "4":
			return new MainMenu();

		default:
			System.out.println("invalid option");
			break;
		}
		return null;
	}

}
