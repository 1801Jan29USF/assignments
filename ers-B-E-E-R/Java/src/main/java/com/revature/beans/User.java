package com.revature.beans;

import org.apache.log4j.Logger;

/**
 * User class for the employee reimbursement system
 * Represents data stored in the ERS database's ers_users table
 * 
 * @author Bobby McGetrick
 *
 */
public class User {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private static Logger log = Logger.getRootLogger();
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int roleId;
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new User
	 */
	public User() {
		super();
		log.info("Constructing new User");
		log.info("Called super constructor - Object");
		log.info("New User created");
	}

	/**
	 * Create new User with predefined values other than the id
	 * 
	 * @param String username
	 * @param String password
	 * @param String firstName
	 * @param String lastName
	 * @param String email
	 * @param int roleId
	 */
	public User(String username, String password, String firstName, String lastName, String email, int roleId) {
		super();
		log.info("Constructing new User");
		log.info("Called super constructor - Object");
		log.info("Setting username = " + username);
		this.username = username;
		log.info("Setting password to the given password");
		this.password = password;
		log.info("Setting firstName = " + firstName);
		this.firstName = firstName;
		log.info("Setting lastName = " + lastName);
		this.lastName = lastName;
		log.info("Setting email = " + email);
		this.email = email;
		log.info("Setting roleId = " + roleId);
		this.roleId = roleId;
		log.info("New User created");
	}
	
	/**
	 * Create new User with predefined values for username and password
	 * 
	 * @param String username
	 * @param String password
	 */
	public User(String username, String password) {
		super();
		log.info("Constructing new User");
		log.info("Called super constructor - Object");
		log.info("Setting username = " + username);
		this.username = username;
		log.info("Setting password to the given password");
		this.password = password;
		log.info("New User created");
	}
	
	/**
	 * Create new User with predefined values other than the password
	 * Used when retrieving a User from the database while not transmitting the password
	 * 
	 * @param int id
	 * @param String username
	 * @param String firstName
	 * @param String lastName
	 * @param String email
	 * @param int roleId
	 */
	public User(int id, String username, String firstName, String lastName, String email, int roleId) {
		super();
		log.info("Constructing new User");
		log.info("Called super constructor - Object");
		log.info("Setting id = " + id);
		this.id = id;
		log.info("Setting username = " + username);
		this.username = username;
		log.info("Setting firstName = " + firstName);
		this.firstName = firstName;
		log.info("Setting lastName = " + lastName);
		this.lastName = lastName;
		log.info("Setting email = " + email);
		this.email = email;
		log.info("Setting roleId = " + roleId);
		this.roleId = roleId;
		log.info("New User created");
	}

	/**
	 * Create new User with predefined values
	 * 
	 * @param int id
	 * @param String username
	 * @param String password
	 * @param String firstName
	 * @param String lastName
	 * @param String email
	 * @param int roleId
	 */
	public User(int id, String username, String password, String firstName, String lastName, String email, int roleId) {
		super();
		log.info("Constructing new User");
		log.info("Called super constructor - Object");
		log.info("Setting id = " + id);
		this.id = id;
		log.info("Setting username = " + username);
		this.username = username;
		log.info("Setting password to the given password");
		this.password = password;
		log.info("Setting firstName = " + firstName);
		this.firstName = firstName;
		log.info("Setting lastName = " + lastName);
		this.lastName = lastName;
		log.info("Setting email = " + email);
		this.email = email;
		log.info("Setting roleId = " + roleId);
		this.roleId = roleId;
		log.info("New User created");
	}
	
	public User(int id, String first, String last) {
		this.id = id;
		this.firstName = first;
		this.lastName = last;
	}

	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate User has code
	 */
	@Override
	public int hashCode() {
		log.info("Genrating User hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + roleId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		log.info("Returning User hash code");
		return result;
	}

	/**
	 * Check if User is equivalent to another Object
	 * @param Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		log.info("Checking if User is equivalent to the passed Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roleId != other.roleId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve User.log
	 * 
	 * @return Logger log
	 */
	public static Logger getLog() {
		return log;
	}
	
	/**
	 * Set User.log to a given Logger
	 * 
	 * @param Logger log
	 */
	public static void setLog(Logger log) {
		User.log = log;
	}

	/**
	 * Retrieve User.id
	 * 
	 * @return int id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set User.id to a given integer
	 * 
	 * @param int id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retrieve User.username
	 * 
	 * @return String username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set User.username to a given String
	 * 
	 * @param String username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Retrieve User.password
	 * 
	 * @return String password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set User.password to a given String
	 * 
	 * @param String password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Retrieve User.firstName
	 * 
	 * @return String firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set User.firstName to a given String
	 * 
	 * @param String firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Retrieve User.lastName
	 * 
	 * @return String lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set User.lastName to a given String
	 * 
	 * @param String lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Retrieve User.email
	 * 
	 * @return String email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set User.email to a given String
	 * 
	 * @param String email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retrieve User.roleId
	 * 
	 * @return int roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * Set User.roleId to a given integer
	 * 
	 * @param int roleId
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
