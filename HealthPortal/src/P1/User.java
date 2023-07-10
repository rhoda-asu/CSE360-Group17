package P1;
import javafx.application.*;
import javafx.stage.Stage;

public abstract class User {
	private String ID;
	private String name;
	private String password;
	private String email;
	
	public User() {}
	
	public User(String ID, String name, String password, String email) {
		this.ID = ID;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	abstract public void view(Stage primaryStage);

	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	


	public void setID(String iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	/*public void updateInformation(String name, String password, String email) {
    		this.name = name;
    		this.password = password;
    		this.email = email;
    		Database.getInstance().updateUser(this);
	}*/
	
}
