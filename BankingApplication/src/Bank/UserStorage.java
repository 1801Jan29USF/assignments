package Bank;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;


public class UserStorage implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final String Username;
    private final String Password;
    private double Balance;
    ArrayList<Transaction> TransactionHistory;
    
   
	@Override
	public String toString() {
		return "UserStorage [Username=" + Username + ", Password=" + Password + ", Balance=" + Balance + "]";
	}
	//Store the User Informations 


	public UserStorage(String username, String password) {
		super();
		Username = username;
		Password = password;
		Balance = 0.0;
		this.TransactionHistory = new ArrayList<Transaction>();
	}
	/**
	 * @return the transactionHistory
	 */
	public ArrayList<Transaction> getTransactionHistory() {
		return TransactionHistory;
	}


	/**
	 * @param transactionHistory the transactionHistory to set
	 */
	public void setTransactionHistory(ArrayList<Transaction> transactionHistory) {
		TransactionHistory = transactionHistory;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(Balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((Username == null) ? 0 : Username.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserStorage other = (UserStorage) obj;
		if (Double.doubleToLongBits(Balance) != Double.doubleToLongBits(other.Balance))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (Username == null) {
			if (other.Username != null)
				return false;
		} else if (!Username.equals(other.Username))
			return false;
		return true;
	}


	public UserStorage(String username, String password, double balance) {
		super();
		Username = username;
		Password = password;
		Balance = balance;
	}	
public void Transaction() {

 if (this.TransactionHistory.size() == 0) 	{
	        System.out.println("You have not made any transactions yet");
 } else {
	 for ( int t = 0; t < this.TransactionHistory.size(); t++) {
		 Transaction trans = this.TransactionHistory.get(t);
		 System.out.println(trans.getDate() + " " + this.Username + " " + trans.Action);
		 
	 
	 }
 }
}


public void addTransaction(String action, Double total) {
	Date time = Calendar.getInstance().getTime();
	Transaction trans = new Transaction(action,total,time);
	TransactionHistory.add(trans);
	
}
}





