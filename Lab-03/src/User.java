import java.net.InetAddress;

public class User {
	
	private String username;
	private boolean active;
	
	public User(InetAddress client, String username) {
		this.username = username;
		this.active = false;
	}
	
	public String getName() {
		return username;
	}
	
	public String setName(String newName) {
		username = newName;
		return "New username is " + username;
	}
	
	public void activate() {
		active = true;
	}
	
	public boolean isActive() {
		return active;
	}

}
