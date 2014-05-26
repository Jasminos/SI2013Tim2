package ba.unsa.etf.si.klase;

import java.util.Date;

public class Administrator implements java.io.Serializable {

	private long id;
	private String username;
	private String password;
	
	
	
	public Administrator() {
		username = "Administrator";
		password = "admin";
	}
	
	public String getUsername() {
		return username;
	}
	public void setIme(String username) {
		this.username = username;
	}

	private long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String value)
	{
		password = value;
	}
	
}
