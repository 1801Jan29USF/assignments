package com.revature.BankingApplication;

public class UserStorage{
		
		private static final long serialVersionUID = 1L;
		private  String Username;
	    private  String Password;
	    private double Balance;	    




	/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			Username = username;
		}


		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			Password = password;
		}


	/**
		 * @return the balance
		 */
		public double getBalance() {
			return Balance;
		}


		/**
		 * @param balance the balance to set
		 */
		public void setBalance(double balance) {
			Balance = balance;
		}


		/**
		 * @return the serialversionuid
		 */
		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		/**
		 * @return the username
		 */
		public String getUsername() {
			return Username;
		}


		/**
		 * @return the password
		 */
		public String getPassword() {
			return Password;
		}


	public UserStorage(String username, String password, double balance) {
			super();
			Username = username;
			Password = password;
			Balance = balance;
		}

   public UserStorage(String username, String password) {
	   super();
	   Username = username;
	   Password = password;
   }

	}


