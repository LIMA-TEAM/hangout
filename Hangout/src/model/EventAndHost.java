package model;

import event.NewEventEvent;

public class EventAndHost {

	private User user;
	private NewEventEvent event;
	
	public EventAndHost() {
		user = new User();
		user.setCreatedTimeStamp(0);
		user.setId(null);
		user.setName(null);
		user.setUsername(null);
		
		event = new NewEventEvent();
		event.setEndTime(0);
		event.setStartTime(0);
		event.setHostId(null);
		event.setId(null);
		event.setLat(0);
		event.setLon(0);
		event.setTitle(null);
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public NewEventEvent getEvent() {
		return event;
	}
	public void setEvent(NewEventEvent event) {
		this.event = event;
	}
	
	
}
