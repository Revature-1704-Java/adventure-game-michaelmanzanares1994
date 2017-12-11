import java.util.*;

public class Location {
	private HashMap<String, Location> exits;			
	private String name;
	
	public Location() { };
	public Location(String name) {
		exits = new HashMap<String, Location>();			
		this.name = name;
	}
	
	public void setExit(String name, Location room) {
		exits.put(name, room);								// mapping key name to value room
	}
	
	public HashMap<String, Location> getMap() {
		return exits;										
	}

	public Location getExit(String direction) {
		return exits.get(direction);						// returns the value to which the specified key is mapped
	}
	
	public String getName() {
		return name;
	}
}