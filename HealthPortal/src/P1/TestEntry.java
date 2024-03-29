package P1;

public class TestEntry {
	private String typeOfTest;
	private String doctorID;
	private String patientID;
	private String results;
	private String observations;
	
	public TestEntry() {}
	
	public TestEntry(String typeOfTest, String doctorID, String patientID, String results, String observations) {
		this.typeOfTest = typeOfTest;
		this.doctorID = doctorID;
		this.patientID = patientID;
		this.results = results;
		this.observations = observations;
	}
	
	@Override
	public String toString() {
		return "Doctor Testing: " + this.doctorID + "Patient being Tested: " + this.patientID + "\nType of Test: " + this.typeOfTest + "\nResults: " + this.results + "\nObservations: " + this.observations;
	}
	
	
}
