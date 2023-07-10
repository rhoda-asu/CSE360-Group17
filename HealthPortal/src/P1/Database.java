package P1;

import java.io.Serializable;
import java.io.*;
import java.util.HashMap;

public class Database implements Serializable {
    private HashMap<String, User> database;
    private static final String filePath = "database.ser";
    private static Database instance; // static instance variable

    public Database() {
        this.database = new HashMap<>();
    }

    public String createUser(int opt, String name, String password, String email) {
        // Generate a unique ID for the user
        String ID = generateUserID();
        
        switch (opt) {
            case 0:
                this.database.put(ID, new Patient(ID, name, password, email));
                break;
            case 1:
                this.database.put(ID, new Doctor(ID, name, password, email));
                break;
            case 2:
                this.database.put(ID, new Nurse(ID, name, password, email));
                break;
            default:
                return "";
        }
        
        saveDatabaseToFile(); // Save the updated database to a file
        return ID;
    }

    public boolean checkPassword(String ID, String password) {
        if (this.database.containsKey(ID)) {
            User user = this.database.get(ID);
            return user.getPassword().equals(password);
        }
        return false;
    }

    public User getUser(String ID) {
        if (this.database.containsKey(ID)) {
            return this.database.get(ID);
        }
        return null;
    }
    
    private String generateUserID() {
        // Generate a unique ID for the user
        String ID = "";
        // Generate a unique ID
        // Here, we're using a simple random number generation
        ID = Integer.toString((int) (Math.random() * 1000));
        return ID;
    }
    
    private void saveDatabaseToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.database);
            out.close();
            fileOut.close();
            System.out.println("Database saved to file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving database to file: " + e.getMessage());
        }
    }
    
    private void loadDatabaseFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.database = (HashMap<String, User>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Database loaded from file: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading database from file: " + e.getMessage());
        }
    }
    
    public void initializeDatabase() {
        File file = new File(filePath);
        if (file.exists()) {
            loadDatabaseFromFile();
        } else {
            saveDatabaseToFile();
        }
    }
    
    public void updateUser(User user) {
        if (this.database.containsKey(user.getID())) {
            this.database.put(user.getID(), user);
            saveDatabaseToFile(); // Save the updated database to the file
        }
    }
    
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    
    public boolean userExists(String ID) {
    	return this.database.containsKey(ID);
    }
    
    public void addPatient(Patient patient) {
        this.database.put(patient.getID(), patient);
    }
    
    public void addDoctor(Doctor doctor) {
        this.database.put(doctor.getID(), doctor);
    }
    
    public void addNurse(Nurse nurse) {
        this.database.put(nurse.getID(), nurse);
    }
}
