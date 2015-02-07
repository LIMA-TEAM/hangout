package database;

//sample: https://3b8d7b13-d98d-4bb1-9451-12c2c57a6e29-bluemix.cloudant.com/hangout/_design/user/_list/listuser/getuser?key=%22test%22
public class DatabaseConstants {

	// Database Info
	public static final String HOST = "3b8d7b13-d98d-4bb1-9451-12c2c57a6e29-bluemix.cloudant.com";
	public static final String USERNAME = "sucessitherfeenceedleton";
	public static final String PASSWORD = "GmoHvMypjw8FKMukb3C52WeW";
	public static final String DB_NAME = "hangout";
	
	// Character to URL conversions
	private static final String URL_DOUBLE_QUOTE_CODE = "%22";
	
	// URLs
	private static final String BASE_URL = "https://3b8d7b13-d98d-4bb1-9451-12c2c57a6e29-bluemix.cloudant.com/hangout/";
	private static final String GET_ACCOUNT_PASSWORD_SUFFIX = "_design/user/_list/listuser/getuser?key=";
	
	// Methods
	public static String getAccountPasswordURL(String username) {
		return "https://" + HOST + "/" + DB_NAME + "/" + GET_ACCOUNT_PASSWORD_SUFFIX + URL_DOUBLE_QUOTE_CODE + username + URL_DOUBLE_QUOTE_CODE;
	}
}



