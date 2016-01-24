//Tom Magnan & Elizabeth Davis

public class User {
	private String username;
	private String password;
	private String name;
	
	public User (String user, String pass, String n) {
		username = user;
		password = pass;
		name = n;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
