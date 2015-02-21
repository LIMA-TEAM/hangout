package event;

public class AddFriendEvent {

	private String userId;
	private String friendIdCSV;

	public String getFriendId() {
		return friendIdCSV;
	}

	public void setFriendId(String friendIdCSV) {
		this.friendIdCSV = friendIdCSV;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
