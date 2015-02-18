package database;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import event.NewEventEvent;

public class DatabaseTest {

	@Test
	public void timeTest() {
//		fail("Not yet implemented");
		Database db = Database.createInstance(null, null);
		
		List<NewEventEvent> events = db.getMostRecentEvents(10);
		
		for (NewEventEvent event : events) {
			Calendar calendar = Calendar.getInstance();
		    calendar.setTimeInMillis(event.getStartTime());
		    System.out.println(calendar.getTime().toString());
		}
	}
	
	@Test
	public void jsonTest() {
		Database db = Database.createInstance(null, null);
		
		System.out.println(db.getMostRecentEventsJson(3));
	}

}
