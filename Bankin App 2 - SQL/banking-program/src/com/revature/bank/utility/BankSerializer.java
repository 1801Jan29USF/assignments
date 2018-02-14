package com.revature.bank.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.bank.bean.User;
/*
 * Bank serialazable is used to allow objects(user's data) to be 
 * saved int txt files through serialzation and desrialzation.
 * 
 */


public class BankSerializer {
	
	
	public void SerilaziableBank(User user, String fileName ) {
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName +".txt"))){
			os.writeObject(user);
			os.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public User DeserializeBank(String fileName) {
		try(ObjectInputStream is = new ObjectInputStream( new FileInputStream(fileName + ".txt"))){
			return (User) is.readObject();
		}catch (FileNotFoundException e) {
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
