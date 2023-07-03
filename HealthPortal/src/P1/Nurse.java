package P1;

import java.util.ArrayList;

public class Nurse extends User{
	
	private ArrayList<Appointment> schedule;
	private ArrayList<String> patients;
	
	public Nurse() {
		super();
	}

	public Nurse(ArrayList<Appointment> schedule, ArrayList<String> patients, String ID, String name, String password, String email) {
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
