package com.revature.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.revature.beans.User;

public class AccountsSerializer {

	public void SerializeUsers(List<User> c, String fileName) {
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName))) {
			os.writeObject(c);
			os.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<User> DeserializeUsers(String fileName) {
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName))) {
			return (List<User>) is.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
}
