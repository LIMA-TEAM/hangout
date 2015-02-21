package utility;

public class ReturnCodes {

	// Login
	public static final int LOGIN_SUCCESS = 1000;
	public static final int LOGIN_USERNAME_DOES_NOT_EXIST = 1001;
	public static final int LOGIN_INCORRECT_PASSWORD = 1002;
	
	// Update User
	public static final int UPDATE_USER_PASSWORD_SUCCESS = 1050;
	public static final int UPDATE_USER_PASSWORD_FAILURE_INCORRECT_OLD_PASS = 1051;
	public static final int UPDATE_USER_PASSWORD_FAILURE_UNKNOWN = 1052;
	
	// New User
	public static final int NEW_USER_SUCCESS = 1100;
	public static final int NEW_USER_USERNAME_ALREADY_EXISTS = 1101;

	// Get User
	public static final int GET_USER_DOES_NOT_EXIST = 1111;
	
	// New Event
	public static final int NEW_EVENT_SUCCESS = 1200;
	public static final int NEW_EVENT_FAILURE = 1201;
	
	// Get Event
	public static final int GET_EVENT_DOES_NOT_EXIST = 1301;
	
	// Get Most Recent Events
	public static final int GET_MOST_RECENT_EVENTS_FAILURE = 1311;
	
	// Add friend
	public static final int ADD_FRIEND_SUCCESS = 1120;
	public static final int ADD_FRIEND_FAILURE = 1121;
	
	// Remove friend
	public static final int REMOVE_FRIEND_SUCCESS = 1130;
	public static final int REMOVE_FRIEND_FAILURE = 1131;

	// Get friends
	public static final int GET_USER_FRIEND_LIST_FAILURE = 1141;
	
	// Search
	public static final int SEARCH_BY_USERNAME_FAILURE = 1401;

}
