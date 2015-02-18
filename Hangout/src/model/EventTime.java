package model;

public class EventTime {

	private String id;
	private long time;
	
	public EventTime(String id, long time) {
		this.id = id;
		this.time = time;
	}
	
	public EventTime(String id, String time) {
		this.id = id;
		this.time = Long.parseLong(time);
	}
	
	public EventTime() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
}
