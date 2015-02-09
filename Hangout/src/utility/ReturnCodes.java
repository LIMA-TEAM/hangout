package utility;

public class ReturnCodes {

	// Login
	public static final int LOGIN_SUCCESS = 1000;
	public static final int LOGIN_USERNAME_DOES_NOT_EXIST = 1001;
	public static final int LOGIN_INCORRECT_PASSWORD = 1002;
	
	// New User
	public static final int NEW_USER_SUCCESS = 1100;
	public static final int NEW_USER_USERNAME_ALREADY_EXISTS = 1101;
	
	// New Event
	public static final int NEW_EVENT_SUCCESS = 1200;
	
	// Get Event
	public static final int GET_EVENT_DOES_NOT_EXIST = 1301;
}
