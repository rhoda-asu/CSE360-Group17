package P1;

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
	
	abstract public void view();

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
	
}
