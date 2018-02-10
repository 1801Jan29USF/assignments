//package com.revature.beans;
//
//public class Bank {
//	transient public Scanner scan = new Scanner(System.in);
//
//	transient private static Logger log = Logger.getRootLogger();
//
//	transient public DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH::mm::ss");
//
//	transient public Date date = new Date();
//	
//
//	// deposits specified amount into either checking or savings
//	public void deposit(User u, int amount, String type) {
//		if (type.hashCode() == "c".hashCode()) {
//			u.checking = u.checking + amount;
//			System.out.println(amount + "$ has been deposited to your Checking account\n");
//			us.SerializeUsers(this.users, "Users.txt");
//			u.transactions.add(dateFormat.format(date) + "	Deposited " + amount + "$ to checking");
//			log.info(u.toString() + " deposited " + amount + "$ to checking");
//		} else {
//			u.savings = u.savings + amount;
//			System.out.println(amount + "$ has been deposited to your Savings account\n");
//			us.SerializeUsers(this.users, "Users.txt");
//			u.transactions.add(dateFormat.format(date) + "	Deposited " + amount + "$ to savings");
//			log.info(u.toString() + " deposited " + amount + "$ to savings");
//		}
//	}
//
//	// withdraws specified amount from checking.
//	public void withdraw(User a, int amount) {
//		if (a.checking - amount < 0) {
//			System.out.println("Insufficient funds in Checking acct\n");
//			log.info(a.toString() + " attempted to withdraw " + amount + "$ but their account had insufficient funds");
//			return;
//		}
//		a.checking = a.checking - amount;
//		us.SerializeUsers(this.users, "Accounts.txt");
//		System.out.println(amount + "$ has been withdrawn from your checking account\n");
//		a.transactions.add(dateFormat.format(date) + "	Withdrew " + amount + "$ from Checking Account");
//		log.info(a.toString() + " withdrew " + amount + "$ from Checking Account");
//	}
//
//	// transfers specified amount from **checking to savings**
//	public void transfer(User a, int amount) {
//		if (a.checking - amount < 0) {
//			System.out.println("Insufficient funds in Checking acct. Cannot complete transfer\n");
//			log.info(a.toString() + " attempted to transfer " + amount + "$ but their account had insufficient funds");
//			return;
//		}
//		a.checking -= amount;
//		a.savings += amount;
//		System.out.println("You transferred " + amount + " $ to " + "Savings\n");
//	}
//
//	// prints out the balance of either checking or savings
//	public void balance(User u, String type) {
//		if (type.hashCode() == "c".hashCode()) {
//			System.out.println(u.checking);
//		} else {
//			System.out.println(u.savings);
//		}
//	}
//
//	// checks if user exists in users ArrayList (for Login)
//	public User checkIfExists(String username, String password) {
//		for (int i = 0; i < this.users.size(); i++) {
//			if (users.get(i).getUsername().hashCode() == username.hashCode()
//					&& users.get(i).getPassword().hashCode() == password.hashCode()) {
//				return users.get(i);
//			}
//		}
//		return null;
//	}
//
//	// checks if username already exists (for Registration)
//	public boolean checkIfExists(String username) {
//		boolean exists = false;
//		for (int i = 0; i < this.users.size(); i++) {
//			if (users.get(i).getUsername().hashCode() == username.hashCode()) {
//				exists = true;
//			}
//		}
//		return exists;
//	}
//
//	// checks if username already exists (for Username change)
//	public boolean checkIfExists(String username, User c) {
//		boolean exists = false;
//		for (int i = 0; i < this.users.size(); i++) {
//			if ((users.get(i).getUsername().hashCode() == username.hashCode())) {
//				exists = true;
//			}
//		}
//		return exists;
//	}
//
//	// changes a user's password and username
//	public void updateUserPass(User c, String username, String password) {
//		c.setPassword(password);
//		c.setUsername(username);
//		us.SerializeUsers(this.users, "Users.txt");
//		log.info(c.toString() + "changed his/her username to " + 
//							username + " and his/her password to" + password + "\n");
//		c.transactions.add(dateFormat.format(date) + "	Changed username to " +
//							username + " and password to " + password + "\n");
//		us.SerializeUsers(this.users, "Users.txt");
//		return;
//	}
//
//	// adds the user into the users ArrayList
//	public void register(User u) {
//		this.users.add(u);
//		us.SerializeUsers(this.users, "Users.txt");
//		log.info(u.toString() + " added");
//	}
//
//	//takes money out of senders checking and adds it to receiver's checking acct
//	//**user can only send money from checking account**
//	public void quickPay(String receiver, User sender, int amount) {
//		if (sender.checking - amount < 0) {
//			System.out.println("Your Checking balance too low for Quickpay transaction\n");
//			return;
//		}
//		boolean userFound = false;
//		for (User user : this.users) {
//			if (receiver.hashCode() == user.getUsername().hashCode()) {
//				userFound = true;
//				user.checking += amount;
//				sender.checking -= amount;
//				us.SerializeUsers(this.users, "Users.txt");
//				System.out.println("\n");
//				user.transactions
//						.add(dateFormat.format(date) + sender.getUsername() + "	Quickpayed you " + amount + "$");
//				sender.transactions
//						.add(dateFormat.format(date) + "	Quickpayed " + amount + "$ to " + user.getUsername());
//				log.info(sender.toString() + " quickpayed " + amount + "$ to " + user.getUsername());
//				System.out.println("You quickpayed" + amount + " $ to " + receiver + "\n");
//			}
//		}
//		if (userFound == false) {
//			System.out.println("Receiver account could not be found. Please check your input\n");
//		}
//	}
//
//	// prints a specific user's transaction history to standard output
//	public void printTrans(User user) {
//		System.out.println("Your Transactions\n");
//		for (String t : user.transactions) {
//			System.out.println(t);
//			System.out.println("\n");
//		}
//		us.SerializeUsers(this.users, "Users.txt");
//		System.out.println("\n");
//	}
//}
