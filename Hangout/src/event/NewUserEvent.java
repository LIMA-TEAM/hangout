package event;

public class NewUserEvent {
	
	private String username;
	private String encryptedPassword;

	private long timeUserCreated;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return encryptedPassword;
	}

	public void setPassword(String password) {
		this.encryptedPassword = password;
	}

	public long getTimeUserCreated() {
		return timeUserCreated;
	}

	public void setTimeUserCreated(long timeUserCreated) {
		this.timeUserCreated = timeUserCreated;
	}
}
