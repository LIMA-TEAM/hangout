package event;

public class NewUserEvent {
	
	private String id;
	private String username;
	private String encryptedPassword;

	private long timeUserCreated;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String password) {
		this.encryptedPassword = password;
	}

	public long getTimeUserCreated() {
		return timeUserCreated;
	}

	public void setTimeUserCreated(long timeUserCreated) {
		this.timeUserCreated = timeUserCreated;
	}
}
