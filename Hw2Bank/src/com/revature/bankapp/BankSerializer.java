package com.revature.bankapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.bankapp.BankUser;
/**
 * Serializes and deserializes all the user info from and array list to a text file and vice-versa.
 * @author Rick
 *
 */
public class BankSerializer {
	
	public void serializeBankUsers(ArrayList<BankUser> aL) {
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("BankList.txt"))) {
			os.writeObject(aL);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<BankUser> deserializeBankUsers() {
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("BankList.txt"))) {
			ArrayList<BankUser> aL = (ArrayList<BankUser>) is.readObject();
			is.close();
			return aL;

		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
