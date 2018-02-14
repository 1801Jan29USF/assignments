package com.revature.file.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.beans.User;

public class UserSerializer {
	

	/**
	 * 	Try to deserialize the object. If it works, report back that the file exists.
	 *	If it doesn't work, report back that the file does not exist.
	 *
	 * @param fileName
	 * @return
	 */
	public boolean exists(String fileName) {
		try(ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(fileName))){
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Copy pasted from lecture. Takes a user object as a parameter and attempts 
	 * to serialize the object to a text file
	 * @param u
	 * @param fileName
	 */
	public void SerializeUser(User u, String fileName) {
		try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(fileName))){
			outStream.writeObject(u);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Copy pasted from lecture. Takes a file name and attempts to deserialize an object
	 * from a text file with that name.
	 * @param fileName
	 * @return
	 */
	public User DeserializeUser(String fileName) {
		try(ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(fileName))){
			return (User) inStream.readObject();
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
