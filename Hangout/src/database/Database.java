package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import model.EventTime;
import model.User;

import org.apache.commons.codec.binary.Base64;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;

import utility.ReturnCodes;

import com.google.gson.Gson;

import container.NewUserEventContainer;
import event.NewEventEvent;
import event.NewUserEvent;
import flexjson.JSONSerializer;

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
	
	//////////////////////////////////////////////////////////////////////////////////////
	
	public int updateUserPassword(String userId, String oldPass, String newPass) {
		if (getAccountPasswordFromId(userId).equals(oldPass)) {
			String userJson = getUserInfoJson(userId);
			Gson gson = new Gson();
			User userInfo = gson.fromJson(userJson, User.class);
			DocumentHandle doc = getUserDocument(userId);
			getDBClient().remove(doc.get_id(), doc.get_rev());
			
			NewUserEvent event = new NewUserEvent();
			event.setId(userInfo.getId());
			event.setUsername(userInfo.getUsername());
			event.setTimeUserCreated(userInfo.getCreatedTimeStamp());
			event.setEncryptedPassword(newPass);
			
			saveNewUser(event);
			
			return ReturnCodes.UPDATE_USER_PASSWORD_SUCCESS;
		}
		else {
			return ReturnCodes.UPDATE_USER_PASSWORD_FAILURE_INCORRECT_OLD_PASS;
		}
	}
	
	public int saveNewUser(NewUserEvent userEvent) {
		if (getAccountPassword(userEvent.getUsername()).equals("")) {
			
			NewUserEventContainer container = new NewUserEventContainer();
			container.setEvent(userEvent);
			
			getDBClient().save(container);
			return ReturnCodes.NEW_USER_SUCCESS;
		} 
		else {
			return ReturnCodes.NEW_USER_USERNAME_ALREADY_EXISTS;
		}
	}
	
	public String getAccountPasswordFromId(String userId) {
		return retrieveDatabaseData(DatabaseConstants.getAccountPasswordFromIdURL(userId));
	}
	
	private CouchDbClient getDBClient() {
		CouchDbProperties properties = new CouchDbProperties()
		  .setDbName(DatabaseConstants.DB_NAME)
		  .setCreateDbIfNotExist(false)
		  .setProtocol("https")
		  .setHost(DatabaseConstants.HOST)
		  .setPort(443)
		  .setUsername(DatabaseConstants.USERNAME)
		  .setPassword(DatabaseConstants.PASSWORD)
		  .setMaxConnections(100)
		  .setConnectionTimeout(0);
		
		return new CouchDbClient(properties);
	}
	
	public String getUserInfoJson(String userId) {
		String rawData = retrieveDatabaseData(DatabaseConstants.getUserInfoURL(userId));
		String[] attributes = rawData.split(",");
		User user = new User();
		user.setId(attributes[0]);
		user.setUsername(attributes[1]);
		user.setPhoneNumber(attributes[2]);
		user.setCreatedTimeStamp(Long.parseLong(attributes[3]));
		return (new Gson()).toJson(user);
	}
	
	private DocumentHandle getUserDocument(String userId) {
		String[] csv = retrieveDatabaseData(DatabaseConstants.getUserDocumentHandleFromUserId(userId)).split(",");
		
		return new DocumentHandle(csv[0], csv[1]);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	
	/*public String getMostRecentEventsXML(int count) {
		StringWriter writer = new StringWriter();
		
		try {

			List<NewEventEvent> events = getMostRecentEvents(count);

			JAXBContext context = JAXBContext.newInstance(NewEventEvent[].class);

		    Marshaller m = context.createMarshaller();
		    
		    NewEventEvent[] eventArr = new NewEventEvent[events.size()];
		    int i = 0;
		    for (NewEventEvent event : events) {
		    	eventArr[i] = event;
		    	i++;
		    }
			m.marshal(eventArr, writer);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		List<NewEventEvent> events = getMostRecentEvents(count);
	    NewEventEvent[] eventArr = new NewEventEvent[events.size()];
	    int i = 0;
	    for (NewEventEvent event : events) {
	    	eventArr[i] = event;
	    	i++;
	    }
		
	    XStream xstream = new XStream();
	    xstream.alias("events", NewEventEvent[].class);
	    return xstream.toXML(eventArr);
	    
	    Serializer serializer = new Persister();
	    
	    try {
			serializer.write(eventArr, writer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    return writer.toString();
	}*/
	
	public String getMostRecentEventsJson(int count) {
		/*List<String> eventJson = new ArrayList<String>();
		List<EventTime> events = new ArrayList<EventTime>();
		String eventString = getAllEventsIdsAndTimes();
		String[] eventArr = eventString.split(";");
		for (String rawEvent : eventArr) {
			String[] rawEventArr = rawEvent.split(",");
			events.add(new EventTime(rawEventArr[0], rawEventArr[1]));
		}
		
		sortEventsByTime(events);
		
		for (int i = 0; i < count; i++) {
			if (i == events.size()) {
				break;
			}
			eventJson.add(getEventJson(events.get(i).getId()));
		}*/
		Gson gson = new Gson();
		List<NewEventEvent> events = getMostRecentEvents(count);
		
		
		return gson.toJson(events.toArray());
	}
	
	public List<NewEventEvent> getMostRecentEvents(int count) {
		List<NewEventEvent> eventList = new ArrayList<NewEventEvent>();
		List<EventTime> events = new ArrayList<EventTime>();
		String eventString = getAllEventsIdsAndTimes();
		String[] eventArr = eventString.split(";");
		for (String rawEvent : eventArr) {
			String[] rawEventArr = rawEvent.split(",");
			events.add(new EventTime(rawEventArr[0], rawEventArr[1]));
		}
		
		sortEventsByTime(events);
		Gson gson = new Gson();
		for (int i = 0; i < count; i++) {
			if (i == events.size()) {
				break;
			}
			eventList.add(gson.fromJson(getEventJson(events.get(i).getId()), NewEventEvent.class));
		}
		
		return eventList;
	}
	
	public String getAllEventsIdsAndTimes() {
		return retrieveDatabaseData(DatabaseConstants.getAllEventsIdsAndTimesURL());
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
		event.setId(attributes[0]);
		event.setTitle(attributes[1]);
		event.setHostId(attributes[2]);
		event.setLat(Double.parseDouble(attributes[3]));
		event.setLon(Double.parseDouble(attributes[4]));
		event.setStartTime(Long.parseLong(attributes[5]));
		event.setEndTime(Long.parseLong(attributes[6]));
		Gson serializer = new Gson();
		
		return serializer.toJson(event);
		
//		String csvData = retrieveDatabaseData(DatabaseConstants.getEventInfoURL(eventId));
//		return Serializer.serializeCSVToJSON(NewEventEvent.class, csvData, DatabaseConstants.LIST_ORDER_EVENT_INFO);
	}
	
	private List<EventTime> sortEventsByTime(List<EventTime> events) {
		for (int i = 0; i < events.size(); i++) {
			for (int j = 0; j < events.size(); j++) {
				if (events.get(i).getTime() > events.get(j).getTime()) {
					EventTime temp = events.get(i);
					events.set(i, events.get(j));
					events.set(j,  temp);
				}
			}
		}
		
		return events;
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
