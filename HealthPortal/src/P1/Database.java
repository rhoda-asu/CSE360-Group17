package P1;

import java.io.*;
import java.util.*;


public class Database implements Serializable{
	private HashMap<String,User> database;
	private static final String filePath = System.getProperty("user.dir");
	
	public Database() {
		this.database = new HashMap<>();
	}
	
	public String createUser(int opt, String name, String password, String email) {
		String ID = "";
	    Random r = new Random( System.currentTimeMillis() );
	    
		while(this.database.containsKey(ID)) {
			ID = String.valueOf(10000 + r.nextInt(20000));
		}
		switch(opt) {
		case 0:
			this.database.put(ID, new Patient(ID, name, password, email));
			return ID;
		case 1:
			this.database.put(ID, new Doctor(ID, name, password, email));
			return ID;
		case 2:
			this.database.put(ID, new Nurse(ID, name, password, email));
			return ID;
		default:
			return "";
		}
	}
	
	public boolean checkPassword(String ID, String password) {
		if(this.database.containsKey(ID) && this.database.get(ID).getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	public User getUser(String ID) {
		if(this.database.containsKey(ID)) {
			return this.database.get(ID);
		}
		return null;
	}
}
