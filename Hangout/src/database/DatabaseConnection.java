package database;

public class DatabaseConnection {

	private String host;
	private String username;
	private String password;
	private String dbname = "hangout";
	
	public DatabaseConnection() {
		host = "3b8d7b13-d98d-4bb1-9451-12c2c57a6e29-bluemix.cloudant.com";
		username = "iverplandiedgromentoorte";
		password = "HLdSVLFQvhbOs8yB8ieSbfsK";
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
}
