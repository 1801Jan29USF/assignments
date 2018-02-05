package com.revature.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.beans.BankUser;

/**
 * Collection of static methods used to used to save user records by serializing
 * them to the text files in src/UserData. Throws exceptions to be handled by
 * calling class.
 * 
 * @author poblo
 *
 */
public class BankUserSerializer {

	// Attempts to de-serialize the BankUser, throwing an exception on failure
	public static BankUser attemptReadBankUser(String fileName) throws Exception {
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName))) {
			return (BankUser) is.readObject();
		}
	}
	// Attempts to serialize the BankUser, throwing an exception on failure
	public static void attemptWriteBankUser(BankUser bu, String fileName) throws Exception {
		try (ObjectOutputStream is = new ObjectOutputStream(new FileOutputStream(fileName))) {
			is.writeObject(bu);
		}
	}
}