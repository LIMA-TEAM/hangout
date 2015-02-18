package event;


public class NewEventEvent implements Model {

	private String id;
	private String title;
	private String hostId;
	private double lat;
	private double lon;
	private long startTime;
	private long endTime;

	public String getHostId() {
		return hostId;
	}
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long time) {
		this.startTime = time;
	}
	public void setStartTime(String time) {
		this.startTime = Long.parseLong(time);
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public void setLat(String lat) {
		this.lat = Double.parseDouble(lat);
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public void setLon(String lon) {
		this.lon = Double.parseDouble(lon);
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = Long.parseLong(endTime);
	}
}
