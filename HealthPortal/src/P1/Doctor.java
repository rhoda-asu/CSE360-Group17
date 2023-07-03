package P1;

import java.util.ArrayList;

public class Doctor extends User{
	private ArrayList<Appointment> schedule;
	private ArrayList<String> patients; //saves patients as strings of their ID's. 
	
	public Doctor() {
		super();
	}
	
	public Doctor(ArrayList<Appointment> schedule, ArrayList<String> patients, String ID, String name, String password, String email) {
		super(ID, name, password, email);
		this.schedule = schedule;
		this.patients = patients;
	}

	public ArrayList<Appointment> getSchedule() {
		return schedule;
	}

	public ArrayList<String> getPatients() {
		return patients;
	}

	public void setSchedule(ArrayList<Appointment> schedule) {
		this.schedule = schedule;
	}

	public void setPatients(ArrayList<String> patients) {
		this.patients = patients;
	}
	
	@Override
	public void view() {}	
	
}
