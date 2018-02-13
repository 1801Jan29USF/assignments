package com.revature.beans;

import java.sql.Timestamp;

public class Transaction {
	private static Transaction t = new Transaction();
	private int id;
	private int userId;
	private double deposited;
	private double withdrawn;
	private Timestamp date;
	
	private Transaction() {
		super();
	}

	public Transaction(int id, int userId, double deposited, double withdrawn, Timestamp date) {
		this.id = id;
		this.userId = userId;
		this.deposited = deposited;
		this.withdrawn = withdrawn;
		this.date = date;
	}
	
	public static Transaction getTransaction() {
		return t;
	}
	
	public static Transaction getTransaction(int id, int userId, double deposited, double withdraw, Timestamp date) {
		t.setId(id);
		t.setUserId(userId);
		t.setDeposited(deposited);
		t.setWithdrawn(withdraw);
		t.setDate(date);
		return t;
	}

	public static Transaction getT() {
		return t;
	}

	public static void setT(Transaction t) {
		Transaction.t = t;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int tranId) {
		this.userId = tranId;
	}

	public double getDeposited() {
		return deposited;
	}

	public void setDeposited(double deposited) {
		this.deposited = deposited;
	}

	public double getWithdrawn() {
		return withdrawn;
	}

	public void setWithdrawn(double withdrawn) {
		this.withdrawn = withdrawn;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(deposited);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + userId;
		temp = Double.doubleToLongBits(withdrawn);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(deposited) != Double.doubleToLongBits(other.deposited))
			return false;
		if (id != other.id)
			return false;
		if (userId != other.userId)
			return false;
		if (Double.doubleToLongBits(withdrawn) != Double.doubleToLongBits(other.withdrawn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", userId=" + userId + ", deposited=" + deposited + ", withdrawn=" + withdrawn
				+ ", date=" + date + "]";
	}
}