package container;

import event.NewUserEvent;

public class NewUserEventContainer {

	private NewUserEvent userInfo;

	public NewUserEvent getEvent() {
		return userInfo;
	}

	public void setEvent(NewUserEvent userInfo) {
		this.userInfo = userInfo;
	}
}
