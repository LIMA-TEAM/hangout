package container;

import event.NewEventEvent;

public class NewEventEventContainer {

	private NewEventEvent eventInfo;

	public NewEventEvent getEvent() {
		return eventInfo;
	}

	public void setEvent(NewEventEvent eventInfo) {
		this.eventInfo = eventInfo;
	}
}
