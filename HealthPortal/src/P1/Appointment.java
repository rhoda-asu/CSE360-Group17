package P1;

public class Appointment {
	private String doctorID;
	private String patientID;
	private String time_date;
	private String description;
	
	public Appointment() {}
	
	public Appointment(String doctorID, String patientID, String time_date, String description) {
		this.doctorID = doctorID;
		this.patientID = patientID;
		this.time_date = time_date;
		this.description = description;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public String getPatientID() {
		return patientID;
	}

	public String getTime_date() {
		return time_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public void setTime_date(String time_date) {
		this.time_date = time_date;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
