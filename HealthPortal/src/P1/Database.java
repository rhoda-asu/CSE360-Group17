package P1;

import java.io.Serializable;
import java.util.HashMap;

public class Database implements Serializable {
    private HashMap<String, User> database;
    private static final String filePath = System.getProperty("user.dir");
    
    public Database() {
        this.database = new HashMap<>();
    }
    
    public String createUser(int opt, String name, String password, String email) {
        String ID = "";
        // Generate a unique ID
        // Here, we're using a simple random number generation
        ID = Integer.toString((int) (Math.random() * 1000));
        
        switch (opt) {
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
