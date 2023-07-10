package P1;

public class HistoryEntry {
	private int ID;
	private String date;
	private String text;
	private int heartRate;
	private int bloodPressure;
	private float temperature;
	
	public HistoryEntry() {}
	
	public HistoryEntry(int ID, String text, int heartRate, int bloodPressure, float temperature, String date) {
		this.ID = ID;
		this.text = text;
		this.heartRate = heartRate;
		this.bloodPressure = bloodPressure;
		this.temperature = temperature;
		this.date = date;
	}

	public int getID() {
		return ID;
	}

	public String getText() {
		return text;
	}

	public int getHeartRate() {
		return heartRate;
	}

	public int getBloodPressure() {
		return bloodPressure;
	}

	public float getTemperature() {
		return temperature;
	}
	
	public String getDate() {
		return this.date;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}

	public void setBloodPressure(int bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Date: " + this.date + "\nHeart Rate: " + this.heartRate + "\nBlood Pressure: " + this.bloodPressure + "\nTemperature: " + this.temperature + "\nObservations: " + this.text;
	}
}
