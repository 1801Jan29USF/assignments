package com.revature.util;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * utility to serialize and deserialize users and user lists
 */
import com.revature.beans.User;

public class SerializeUser {
	
	public void serializeUser(User c, String filename) {
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename))){
			os.writeObject(c);
			os.flush();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void serializeList (ArrayList<User> l, String filename) {
		
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename))){
			os.writeObject(l);
			os.flush();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public User deserializeUser(String filename) {
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename))){
			return (User) is.readObject();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<User> deserializeList(String filename) {
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename))){
			return (ArrayList<User>) is.readObject();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(EOFException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
