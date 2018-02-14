package com.revature.bank.screens;

import java.sql.Timestamp;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bank.bean.User;
import com.revature.bank.bean.UserTranactions;
import com.revature.bank.dao.TransactionsDAO;
import com.revature.bank.dao.TransactionsDAOJDBC;
import com.revature.bank.dao.UserScreenDAO;
import com.revature.bank.dao.UserScreenDAOJDB;

/**
 * User Screen is the where a user is able to view balance, deposit, and withdaw
 * from account. The user is able to use this screen as long as they are logged
 * on. At the end of each activity, the user returns to this screen. Once the
 * user logs off, they return to main menu
 * 
 * @author Ahmed
 *
 */
public class UserScree implements Screen {

	private Logger log = Logger.getRootLogger();

	UserScreenDAO us = new UserScreenDAOJDB();

	User user = new User();
	UserTranactions trans = new UserTranactions();
	TransactionsDAO tr = new TransactionsDAOJDBC();

	public UserScree(User user) {

		this.user = user;
	}

	private Scanner scan = new Scanner(System.in);

	@SuppressWarnings("null")
	@Override
	public Screen prompt() {
		System.out.println("Please select an option.");
		System.out.println("Enter 1 to Veiw your Balance");
		System.out.println("Enter 2 to make a deposit");
		System.out.println("Enter 3 to withdraw");
		//System.out.println("Enter 4 to View Transactions History");
		System.out.println("Enter 4 to log out");

		String input = scan.nextLine();

		switch (input) {
		case "1":

			System.out.println("----------------------------------------------------------");
			System.out.println("Your current balance is $" + us.viewBalance(user.getUserName()));
			System.out.println("----------------------------------------------------------");

			return new UserScree(user);

		case "2":

			System.out.println("Please amount you want to deposit");
			double amountD = Double.parseDouble(scan.nextLine());

			if (amountD >= 0) {
				// trans.setUserId(user.getUserid());
				// trans.setAmntDeposit(amountD);
				// trans.setAmntWithdra(0);
				// trans.setCurrentTime(new Timestamp(System.currentTimeMillis()));
				// tr.addTransaction(user, trans);
				us.deposit(user.getUserName(), amountD);
			}

			System.out.println("You have susccessfully made a deposit");
			System.out.println("----------------------------------------------------------");
			System.out.println("Your new balance is $" + us.viewBalance(user.getUserName()));
			System.out.println("----------------------------------------------------------");
			return new UserScree(user);

		case "3":
			System.out.println("Please amount you want to withdraw");
			double amountw = Double.parseDouble(scan.nextLine());

			if (amountw >= us.viewBalance(user.getUserName())) {
				System.out.println("You have insufficiant fund.");
				System.out.println("----------------------------------------------------------");
				return new UserScree(user);

			} else {
				// trans.setUserId(user.getUserid());
				// trans.setAmntDeposit(0);
				// trans.setAmntWithdra(amountw);
				// trans.setCurrentTime(new Timestamp(System.currentTimeMillis()));
				tr.addTransaction(user, trans);
				us.withdaw(user.getUserName(), amountw);
				System.out.println("You have susccessfully made a withdrawl");
				System.out.println("----------------------------------------------------------");
				System.out.println("Your new balance is $" + us.viewBalance(user.getUserName()));
				System.out.println("----------------------------------------------------------");

			}

			return new UserScree(user);

		case "4":

			// case "5":
			return new MainMenu();

		default:
			System.out.println("invalid option");
			break;
		}
		return new LoginScreen();
	}

}
