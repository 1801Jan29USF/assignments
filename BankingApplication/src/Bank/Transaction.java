package Bank;
import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
    String Action;
    Double Amount;	
    Date Date;
    public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(String action, Double amount, Date date) {
		super();
		Action = action;
		this.Amount = amount;
		Date = date;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return Action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		Action = action;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return Amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.Amount = amount;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return Date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		Date = date;
	}
}
