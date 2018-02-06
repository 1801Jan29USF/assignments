package Bank;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import Bank.UserStorage;


public class UserSerialization {
	
//SerializeUserCredential to create Profile 
	public void SerializerUserCredential(UserStorage info, String filename) {
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename))) {
			os.writeObject(info);
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace(); } catch (IOException e) {
				e.printStackTrace();
 		}
	}
	
//DeserializeUserCredential
	public UserStorage getUser(String filename) {
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename))) {
			return (UserStorage) is.readObject();		
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
	

