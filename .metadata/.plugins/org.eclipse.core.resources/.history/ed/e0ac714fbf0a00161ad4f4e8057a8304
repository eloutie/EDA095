public class Mailbox {
	
	private String message;
	
	public Mailbox() {
		message = "";
	}
	
	public synchronized void write(User user, String message) throws InterruptedException {
		while(!message.equals("")) {
			wait();
		}
		
		this.message = user.getName() + message;
		
		notifyAll();
	}
	
	public synchronized String getMessage() throws InterruptedException {
		while(!message.equals("")) {
			wait();
		}
		
		String temp = message;
		message = "";
		notifyAll();
		return temp;
	}
}
