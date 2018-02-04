package com.bank.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.bank.beans.AuthUser;
import com.bank.screens.LoginScreen;

public class UserSerializer implements Serializable {

	private static UserSerializer us = new UserSerializer();

	// since our userSerializer is a singleton, we unserialize the List when the
	// application starts, so that our getUsers() method simply returns the list
	// acquired at program runtime. Solved a persistent issue of getUsers() always
	// returning a new copy of the original list

	private UserSerializer() {
		super();
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("users.txt"))) {
			currentList = (List<AuthUser>) is.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			currentList = new ArrayList<>();
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 485931239107136095L;

	private AuthUser currentuser;

	private List<AuthUser> currentList;

	// method to serialize the list of users into the text file "users.txt"
	public void serializeUser(List<AuthUser> users) {
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("users.txt"))) {
			os.writeObject(users);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// started creating a method to serialize 'current user' but it was unnecessary
	// and left in so you can see my process

	// public void serializeCurrent(AuthUser current) {
	// List<AuthUser> userList = us.getUsers();
	//
	// }
	
	// returns the list 'currentList' instantiated in this class's constructor.
	public List<AuthUser> getUsers() {
		return currentList;
	}

	public void addUser(AuthUser m) {
		// List<AuthUser> users = new ArrayList<>();

		// The constructor logic now creates a new list if one didn't already exist, the
		// above line is unnecessary

		List<AuthUser> users = getUsers();
		users.add(m);
		serializeUser(users);
		System.out.println("User added.");
		System.out.println(getUsers());

	}

	//getter for 'current user' in changing balance methods
	public AuthUser getCurrentuser() {
		return currentuser;
	}

	public void setCurrentuser(AuthUser currentuser) {
		this.currentuser = currentuser;
	}

	//returns the user serializer singleton
	public static UserSerializer getUserSerializer() {
		return us;
	}

}
