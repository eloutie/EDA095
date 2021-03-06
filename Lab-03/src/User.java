import java.net.Socket;

public class User {
	
	private String username;
	private boolean active;
	private Socket socket;
	
	public User(Socket socket, String username) {
		this.socket = socket;
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

	public Socket getSocket() {
		return socket;
	}
}
