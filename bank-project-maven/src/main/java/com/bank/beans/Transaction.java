package com.bank.beans;

public class Transaction {
	
	protected int u_id;
	protected int transact_id;
	protected double before_balance;
	protected double after_balance;
	protected String log_time;
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getTransact_id() {
		return transact_id;
	}
	public void setTransact_id(int transact_id) {
		this.transact_id = transact_id;
	}
	public double getBefore_bal() {
		return before_balance;
	}
	public void setBefore_bal(double before_balance) {
		this.before_balance = before_balance;
	}
	public double getAfter_bal() {
		return after_balance;
	}
	public void setAfter_bal(double after_balance) {
		this.after_balance = after_balance;
	}
	public String getLog_time() {
		return log_time;
	}
	public void setLog_time(String log_time) {
		this.log_time = log_time;
	}
	@Override
	public String toString() {
		return "[Transaction ID:" + transact_id + ", Before Balance:" + before_balance
				+ ", After Balance:" + after_balance + ", Time:" + log_time + "]";
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int transact_id,int u_id, double before_balance, double after_balance, String log_time) {
		super();
		this.transact_id = transact_id;
		this.u_id = u_id;
		this.before_balance = before_balance;
		this.after_balance = after_balance;
		this.log_time = log_time;
	}

}
