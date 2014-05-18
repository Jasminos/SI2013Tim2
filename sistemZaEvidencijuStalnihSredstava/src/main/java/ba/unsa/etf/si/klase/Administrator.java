package ba.unsa.etf.si.klase;

import java.util.Date;

public class Administrator implements java.io.Serializable {

	private long id;
	private String username;
	private String password;
	
	
	
	public Administrator() {
		username="Administrator";
		password = "Administrator";
	}
	
	String getUsername() {
		return username;
	}
	void setIme(String username) {
		this.username = username;
	}

	private long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}


	
}
