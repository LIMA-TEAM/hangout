package event;

public class LoginEvent {

	private String username;
	private String encryptedPassword; // eventually need to encrypt password (not for
								// demo purposes)

	private long timeStamp;

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

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
