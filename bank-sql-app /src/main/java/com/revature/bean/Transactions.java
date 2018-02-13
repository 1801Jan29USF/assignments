package com.revature.bean;

import java.io.Serializable;
import java.sql.Date;

public class Transactions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1463563638197384729L;
	int amount;
	Date date;
	String info;

	
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Transactions(int depositAmount, String info,Date date) {
		super();
		this.amount = depositAmount;
		this.date = date;
		this.info = info;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((info == null) ? 0 : info.hashCode());
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
		Transactions other = (Transactions) obj;
		if (amount != other.amount)
			return false;	
	
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		return true;
	}
	
	
	
	
	
	

}
