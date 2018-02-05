package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.beans.User;

public class BankSerializer {
	public void serializeBank(User user, String userName) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(userName + ".txt"))) {
			oos.writeObject(user);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addUser(User u, String userName) {
		serializeBank(u, userName);
	}

	// public User[] getUsers() {
	// try (ObjectInputStream ois = new ObjectInputStream(new
	// FileInputStream("Bank.txt"))) {
	// return (User[]) ois.readObject();
	// } catch (FileNotFoundException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }

	public User getUser(String userName) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(userName + ".txt"))) {
			return (User) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}