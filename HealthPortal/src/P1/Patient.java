package P1;

import java.util.ArrayList;

public class Patient extends User{
	private double height;
	private double weight;
	private String sex;
	private ArrayList<HistoryEntry> medicalHistory;
	private ArrayList<TestEntry> tests;
	private ArrayList<Appointment> schedule;
	
	public Patient() {
		super();
	}
	

	public Patient(String ID, String name, String password, double height, double weight, String sex, ArrayList<HistoryEntry> medicalHistory, ArrayList<TestEntry> tests, ArrayList<Appointment> schedule, String email) {
		super(ID, name, password, email);
		this.height = height;
		this.weight = weight;
		this.sex = sex;
		this.medicalHistory = medicalHistory;
		this.tests = tests;
		this.schedule = schedule;
	}


	public double getHeight() {
		return height;
	}


	public double getWeight() {
		return weight;
	}


	public String getSex() {
		return sex;
	}


	public ArrayList<HistoryEntry> getMedicalHistory() {
		return medicalHistory;
	}


	public ArrayList<TestEntry> getTests() {
		return tests;
	}


	public ArrayList<Appointment> getSchedule() {
		return schedule;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public void setMedicalHistory(ArrayList<HistoryEntry> medicalHistory) {
		this.medicalHistory = medicalHistory;
	}


	public void setTests(ArrayList<TestEntry> tests) {
		this.tests = tests;
	}


	public void setSchedule(ArrayList<Appointment> schedule) {
		this.schedule = schedule;
	}
	
	@Override
	public void view() {}
	
	
	
}