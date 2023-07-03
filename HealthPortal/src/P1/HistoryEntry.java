package P1;

public class HistoryEntry {
	private int ID;
	private String text;
	private int heartRate;
	private int bloodPressure;
	private float temperature;
	
	public HistoryEntry() {}
	
	public HistoryEntry(int ID, String text, int heartRate, int bloodPressure, float temperature) {
		this.ID = ID;
		this.text = text;
		this.heartRate = heartRate;
		this.bloodPressure = bloodPressure;
		this.temperature = temperature;
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

	public void setID(int iD) {
		ID = iD;
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
	
	
}
