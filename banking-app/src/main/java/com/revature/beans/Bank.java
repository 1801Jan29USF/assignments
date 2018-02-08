package com.revature.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class Bank implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5062820188277554426L;
	private Map<String, User> users = new HashMap<String, User>();
	private int id;
//	private final transient ScannerSingleton scan = ScannerSingleton.getScannerSingleton();
	private static Logger log = Logger.getRootLogger();

	public Bank() {
		super();
		log.info("Creating bank");
	}

	public Bank(int id) {
		super();
		log.info("Creating bank");
		log.info("Setting this.id");
		this.id = id;
	}

	public Bank(Map<String, User> users, int id) {
		super();
		log.info("Creating bank");
		log.info("Setting this.users");
		this.users = users;
		log.info("Setting this.id");
		this.id = id;
	}

	@Override
	public int hashCode() {
		log.info("Calculating hashCode");
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		log.info("Returning hashCode");
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		log.info("Checking equals");
		if (this == obj) {
			log.info("Equal, returning true");
			return true;
		}
		if (obj == null) {
			log.info("Not equal, returning true");
			return false;
		}
		if (getClass() != obj.getClass()) {
			log.info("Not equal, returning true");
			return false;
		}
		Bank other = (Bank) obj;
		if (id != other.id) {
			log.info("Not equals, returning true");
			return false;
		}
		if (users == null) {
			if (other.users != null) {
				log.info("Not equal, returning true");
				return false;
			}
		} else if (!users.equals(other.users)) {
			log.info("Not equal, returning true");
			return false;
		}
		log.info("Equal, returning true");
		return true;
	}

	public Map<String, User> getUsers() {
		log.info("Returning this.users");
		return users;
	}

	public void setUsers(Map<String, User> users) {
		log.info("Setting this.users");
		this.users = users;
	}

	public int getId() {
		log.info("Returning this.id");
		return id;
	}

	public void setId(int id) {
		log.info("Setting this.id");
		this.id = id;
	}

	public String toString() {
		log.info("Converting Bank to a string");
		return "Bank [users= " + users + "]";
	}

}
