import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class tests {
	Play play = new Play("Joe");
	Location location = new Location();
	Location testLocation = new Location("testLocation");
	
//	private HashMap<String, Location> testHM;
//	testHM = new HashMap<String, Location>();
//	testHM.put("item1", item1);
//	testHM.put("item2", item2);
	

	@Before
	public void setUp() {
		
	}
	
	@Test 
	public void TestDied() {
		assertTrue(!play.died());
	}
	
	@Test 
	public void TestFinish() {
		assertTrue(play.finish());
	}
	/*
	@Test
	public void testGetExit() {
		location.setExit("testString", testLocation);
		assertTrue(, );
	}
	*/
	
	@Test
	public void testGetName() {
		assertTrue(testLocation.getName().equals("testLocation"));
	}
	
//	@Test
//	public void testGetMap() {
//		assertTrue(testHM.getMap());
//	}
	
	@After
	public void shutDown() {
		
	}
}
