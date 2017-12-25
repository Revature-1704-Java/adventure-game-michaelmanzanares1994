import java.util.*;

public class LocationBean {									// location bean
	private HashMap<String, LocationBean> exits;			// hash map data structure
	private String name;
	
	public LocationBean() { };								// default constructor
	public LocationBean(String name) {						// constructor with name parameter that makes a hash map of exits
		exits = new HashMap<String, LocationBean>();			
		this.name = name;
	}
	
	public String getName() {								// getter for name of location
		return name;
	}
	
	public LocationBean getExit(String direction) {			// getter for exits
		return exits.get(direction);						// returns the value to which the specified direction key is mapped
	}
	
	public void setExit(String name, LocationBean room) {	// setter for exits
		exits.put(name, room);								// the put() maps the key name to the value room
	}
	
	public HashMap<String, LocationBean> getMap() {			// getter for all exits
		return exits;										
	}
}