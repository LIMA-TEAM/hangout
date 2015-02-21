package database;

import org.junit.Test;

public class DatabaseTest {

	@Test
	public void jsonTest() {
		Database db = Database.createInstance(null, null);
		
//		System.out.println(db.getMostRecentEventsJson(8));
	}
	
	@Test
	public void eventReturnTest() {
//		System.out.println(Database.createInstance(null, null).getEventJson("65bdaa36-8379-4498-b92e-6cd809c99e29"));
	}
	
	@Test
	public void addFriendTest() {
		Database db = Database.createInstance(null, null);
		String userId = "cd7ab200-6bc8-4987-b043-6bd879dc69aa";
//		db.addFriend(userId, "bfd36086-d117-431b-902a-4412e8aa614b");
//		System.out.println(Database.createInstance(null, null).removeFriend(userId, "bfd36086-d117-431b-902a-4412e8aa614b"));
//		System.out.println(db.getFriendsListIds(userId));
//		System.out.println(db.getUserInfoJson("93dea85b-9429-4289-8934-86959d46b1dd"));
		System.out.println(db.getUserFriendListById(userId));
		
	}

}
