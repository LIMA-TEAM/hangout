package utility;

public class ActionCodes {

	// User
	public static final int NEW_USER_ACTION = ReturnCodes.NEW_USER_SUCCESS/10;
	public static final int UPDATE_USER_PASSWORD_ACTION = ReturnCodes.UPDATE_USER_PASSWORD_SUCCESS/10;
	public static final int USER_LOGIN_ACTION = ReturnCodes.LOGIN_SUCCESS/10;
	public static final int GET_USER_INFO_ACTION = ReturnCodes.GET_USER_DOES_NOT_EXIST/10;
	
	// Event
	public static final int NEW_EVENT_ACTION = ReturnCodes.NEW_EVENT_SUCCESS/10;
	public static final int GET_EVENT_INFO_ACTION = ReturnCodes.GET_EVENT_DOES_NOT_EXIST/10;
	public static final int GET_MOST_RECENT_EVENTS_ACTION = ReturnCodes.GET_MOST_RECENT_EVENTS_FAILURE/10;
	public static final int ADD_FRIEND_ACTION = ReturnCodes.ADD_FRIEND_FAILURE/10;
	public static final int REMOVE_FRIEND_ACTION = ReturnCodes.REMOVE_FRIEND_SUCCESS/10;
	public static final int SEARCH_BY_USERNAME = ReturnCodes.SEARCH_BY_USERNAME_FAILURE/10;
	public static final int GET_USER_FRIEND_LIST = ReturnCodes.GET_USER_FRIEND_LIST_FAILURE/10;
}
