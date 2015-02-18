package utility;

import static org.junit.Assert.*;

import org.junit.Test;

import database.Database;
import event.NewEventEvent;

public class SerializerTest {

	@Test
	public void test() {
//		fail("Not yet implemented");
		/*String csv = "8a,EVENT,69,41.667,91.533,1000000,1000000";
		String attributeOrder = "id,title,hostId,lat,lon,startTime,endTime";
		System.out.println(Serializer.serializeCSVToJSON(NewEventEvent.class, csv, attributeOrder));*/
		Database db = Database.createInstance(null, null);
		System.out.println(db.getEventJson("106b2fbb-fd28-49da-9715-437cb959c48f"));
	}

}
