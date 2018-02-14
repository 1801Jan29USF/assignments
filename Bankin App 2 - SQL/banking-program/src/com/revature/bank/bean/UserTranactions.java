package com.revature.bank.bean;

import java.sql.Timestamp;

public class UserTranactions {
	
	private int userTrans;
	private int userId;	
	private double amntDeposit;
	private double amntWithdra;
	private Timestamp currentTime;
	
	
	public UserTranactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserTranactions(int userTrans, int userId, double amntDeposit, double amntWithdra, Timestamp currentTime) {
		super();
		this.userTrans = userTrans;
		this.userId = userId;
		this.amntDeposit = amntDeposit;
		this.amntWithdra = amntWithdra;
		this.currentTime = currentTime;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the amntDeposit
	 */
	public double getAmntDeposit() {
		return amntDeposit;
	}
	/**
	 * @param amntDeposit the amntDeposit to set
	 */
	public void setAmntDeposit(double amntDeposit) {
		this.amntDeposit = amntDeposit;
	}
	/**
	 * @return the amntWithdra
	 */
	public double getAmntWithdra() {
		return amntWithdra;
	}
	/**
	 * @param amntWithdra the amntWithdra to set
	 */
	public void setAmntWithdra(double amntWithdra) {
		this.amntWithdra = amntWithdra;
	}
	/**
	 * @return the currentTime
	 */
	public Timestamp getCurrentTime() {
		return currentTime;
	}
	/**
	 * @param currentTime the currentTime to set
	 */
	public void setCurrentTime(Timestamp currentTime) {
		this.currentTime = currentTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amntDeposit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(amntWithdra);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((currentTime == null) ? 0 : currentTime.hashCode());
		result = prime * result + userId;
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
		UserTranactions other = (UserTranactions) obj;
		if (Double.doubleToLongBits(amntDeposit) != Double.doubleToLongBits(other.amntDeposit))
			return false;
		if (Double.doubleToLongBits(amntWithdra) != Double.doubleToLongBits(other.amntWithdra))
			return false;
		if (currentTime == null) {
			if (other.currentTime != null)
				return false;
		} else if (!currentTime.equals(other.currentTime))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserTranactions [userId=" + userId + ", amntDeposit=" + amntDeposit + ", amntWithdra=" + amntWithdra
				+ ", currentTime=" + currentTime + "]";
	}
	
	



}
