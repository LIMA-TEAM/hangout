package container;

import event.LoginEvent;

public class LoginEventContainer {

	private LoginEvent credentials;

	public LoginEvent getEvent() {
		return credentials;
	}

	public void setEvent(LoginEvent credentials) {
		this.credentials = credentials;
	}
	
}