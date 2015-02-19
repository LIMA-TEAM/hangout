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
	private static final String AND = "&";
	private static final String INCLUDE_DOCS = "include_docs=true";
	
	// Document Retrieval URLs
	private static final String GET_ACCOUNT_DOCUMENT_ID_SUFFIX = "_design/user/_list/listdochandle/getdoc?key=";
	
	// URLs
//	private static final String BASE_URL = "https://3b8d7b13-d98d-4bb1-9451-12c2c57a6e29-bluemix.cloudant.com/hangout/";
	private static final String GET_ACCOUNT_PASSWORD_SUFFIX = "_design/user/_list/listuser/getuser?key=";
	private static final String GET_ACCOUNT_ID_SUFFIX = "_design/user/_list/listuser/getid?key=";
	private static final String GET_ACCOUNT_PASSWORD_FROM_ID_SUFFIX = "_design/user/_list/listuser/getpassfromid?key=";
	private static final String GET_ACCOUNT_NAME_FROM_ID_SUFFIX = "_design/user/_list/listuser/getnamefromid?key=";
	private static final String GET_EVENT_INFO_SUFFIX = "_design/event/_list/listevent/getevent?key=";
	private static final String GET_EVENTS_ALL_IDS_AND_TIMES = "_design/event/_list/listtimes/getall?";
	private static final String GET_ACCOUNT_INFO_SUFFIX = "_design/user/_list/listuserinfo/getdoc?key=";
	
	// List Attribute Order
	public static final String LIST_ORDER_EVENT_INFO = "id,title,hostId,lat,lon,startTime,endTime";
	
	// Methods
	public static String getAccountPasswordURL(String username) {
		return "https://" + HOST + "/" + DB_NAME + "/" + GET_ACCOUNT_PASSWORD_SUFFIX + URL_DOUBLE_QUOTE_CODE + username + URL_DOUBLE_QUOTE_CODE;
	}
	
	public static String getUserIdURL(String username) {
		return "https://" + HOST + "/" + DB_NAME + "/" + GET_ACCOUNT_ID_SUFFIX + URL_DOUBLE_QUOTE_CODE + username + URL_DOUBLE_QUOTE_CODE;
	}
	
	public static String getEventInfoURL(String id) {
		return "https://" + HOST + "/" + DB_NAME + "/" + GET_EVENT_INFO_SUFFIX + URL_DOUBLE_QUOTE_CODE + id + URL_DOUBLE_QUOTE_CODE + AND + INCLUDE_DOCS;
	}
	
	public static String getAllEventsIdsAndTimesURL() {
		return "https://" + HOST + "/" + DB_NAME + "/" + GET_EVENTS_ALL_IDS_AND_TIMES + INCLUDE_DOCS;
	}

	public static String getAccountPasswordFromIdURL(String userId) {
		return "https://" + HOST + "/" + DB_NAME + "/" + GET_ACCOUNT_PASSWORD_FROM_ID_SUFFIX + URL_DOUBLE_QUOTE_CODE + userId + URL_DOUBLE_QUOTE_CODE;
	}
	
	public static String getUserInfoURL(String userId) {
		return "https://" + HOST + "/" + DB_NAME + "/" + GET_ACCOUNT_INFO_SUFFIX + URL_DOUBLE_QUOTE_CODE + userId + URL_DOUBLE_QUOTE_CODE + AND + INCLUDE_DOCS;
	}
	
	public static String getUserDocumentHandleFromUserId(String userId) {
		return "https://" + HOST + "/" + DB_NAME + "/" + GET_ACCOUNT_DOCUMENT_ID_SUFFIX + URL_DOUBLE_QUOTE_CODE + userId + URL_DOUBLE_QUOTE_CODE + AND + INCLUDE_DOCS; 
	}
	
	public static String getUserStringNameFromId(String userId) {
		return "https://" + HOST + "/" + DB_NAME + "/" + GET_ACCOUNT_NAME_FROM_ID_SUFFIX + URL_DOUBLE_QUOTE_CODE + userId + URL_DOUBLE_QUOTE_CODE;
	}
}



