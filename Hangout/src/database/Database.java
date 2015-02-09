package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;

import event.NewEventEvent;

public class Database {

	//When requesting data, the user must always pass in their authentication token. The token may then be used in the
	//static instantiation method to get a database object. If the authentication token is incorrect, null will be 
	//returned. 
	
	public static Database createInstance(String username, String token) {
		///TODO look up token in database
		// if token matches, create database instance and return it
		// else return null
		
		return new Database();
	}
	
	private Database() {
		
	}
	
	public String getAccountPassword(String username) {
		return retrieveDatabaseData(DatabaseConstants.getAccountPasswordURL(username));
	}
	
	public String getUserId(String username) {
		return retrieveDatabaseData(DatabaseConstants.getUserIdURL(username));
	}
	
	public String getEventJson(String eventId) {
		String rawData = retrieveDatabaseData(DatabaseConstants.getEventInfoURL(eventId));
		String[] attributes = rawData.split(",");
		NewEventEvent event = new NewEventEvent();
		event.setId(eventId);
		event.setTitle(attributes[0]);
		event.setHostId(attributes[1]);
		event.setLat(Double.parseDouble(attributes[2]));
		event.setLon(Double.parseDouble(attributes[3]));
		event.setStartTime(Long.parseLong(attributes[4]));
		event.setEndTime(Long.parseLong(attributes[5]));
		Gson serializer = new Gson();
		
		return serializer.toJson(event);
	}
	
	private String retrieveDatabaseData(String urlString) {
		String data = null;
		
		URL url;
		try {
			url = new URL(urlString);
			
			URLConnection conn = openConnection(url);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));

			// reads from file or url
			data = "";
			String line = null;
			while ((line = reader.readLine()) != null) {
				String realline = line.replaceAll("&#39;", "'");
				realline = line.replaceAll("%27;", "'");
				data += realline;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			return "URL: " + urlString;
		}
		
		return data;
	}
	
	private URLConnection openConnection(URL url) throws IOException {
		URLConnection conn = url.openConnection();
		String userpass = DatabaseConstants.USERNAME + ":" + DatabaseConstants.PASSWORD;
		String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
		conn.setRequestProperty ("Authorization", basicAuth);
		conn.setDoInput(true);
		conn.setDoOutput(false);
		
		return conn;
	}
}
