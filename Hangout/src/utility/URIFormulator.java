package utility;


public class URIFormulator {

	public static final String GET_ALL_USERNAMES = "https://afisch710.cloudant.com/hackathon/_design/user/_list/getusernames/getuser&include_docs=true";
	
	public static String formGetCredentialsURI(String username) {
		return "https://hackwar.mybluemix.net/getCredentials?username=" + username;
	}
	
	public static String formGetBioDocIdFromUsername(String username) {
		return "https://afisch710.cloudant.com/hackathon/_design/user/_list/getvalue/getbioid?key=%22" + username + "%22&include_docs=true";
	}
	
	public static String formGetBioDocRevFromUsername(String username) {
		return "https://afisch710.cloudant.com/hackathon/_design/user/_list/getvalue/getbiorev?key=%22" + username + "%22&include_docs=true";
	}
	
	public static String formGetInterestsDocIdFromUsername(String username) {
		return "https://afisch710.cloudant.com/hackathon/_design/user/_list/getvalue/getinterestsid?key=%22" + username + "%22&include_docs=true";
	}
	
	public static String formGetInterestsDocRevFromUsername(String username) {
		return "https://afisch710.cloudant.com/hackathon/_design/user/_list/getvalue/getinterestsrev?key=%22" + username + "%22&include_docs=true";
	}
	
	public static String formFetchBio(String username) {
		return "https://afisch710.cloudant.com/hackathon/_design/user/_list/getvalue/getuserbio?key=%22" + username + "%22&include_docs=true";
	}
	
	public static String formFetchInterests(String username) {
		return "https://afisch710.cloudant.com/hackathon/_design/user/_list/getvalue/getuserinterests?key=%22" + username + "%22&include_docs=true";
	}
}
