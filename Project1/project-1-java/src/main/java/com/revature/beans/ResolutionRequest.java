package com.revature.beans;

import java.sql.Timestamp;

public class ResolutionRequest {
	private String username;
	private String password;
	private int id;
	private String newStatus;
	
	public ResolutionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResolutionRequest(String username, String password, int id, Timestamp submitted, String newStatus) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
		this.newStatus = newStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((newStatus == null) ? 0 : newStatus.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		ResolutionRequest other = (ResolutionRequest) obj;
		if (id != other.id)
			return false;
		if (newStatus == null) {
			if (other.newStatus != null)
				return false;
		} else if (!newStatus.equals(other.newStatus))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNewStatus() {
		return newStatus;
	}
	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}

}
