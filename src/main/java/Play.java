import java.util.*;

public class Play {
	Scanner keyboard = new Scanner(System.in);			// access user input
	boolean beginning = true;
	private boolean died = false;
	private boolean won = false;
	@SuppressWarnings("unused")
	private String name;
	
	private Location currentRoom;						// Encapsulation 
	private Location bed		= new Location("bed");	// create rooms
	private Location kitchen 	= new Location("kitchen");
	private Location house		= new Location("house");
	private Location car		= new Location("car");
	@SuppressWarnings("unused")
	private Location wendys		= new Location("wendys");	
	@SuppressWarnings("unused")
	private Location diner		= new Location("diner");
	private Location work		= new Location("work");
	private Location classroom	= new Location("classroom");
	@SuppressWarnings("unused")
	private Location lobby 		= new Location("lobby");

	public Play(String playerName) {
		currentRoom = bed;								// create starting location
		name = playerName;

		bed.setExit("car", car);						// create exits
		bed.setExit("bed", bed);						// able to create any new exit location easily
		bed.setExit("kitchen", null);

		house.setExit("house", null);					// null represents a death, wrong choice
		house.setExit("car", car);
		
		car.setExit("house", null);
		car.setExit("work", work);
		car.setExit("wendys", null);
		car.setExit("diner", null);

		work.setExit("car", null);
		work.setExit("classroom", classroom);
		work.setExit("lobby", null);
	}
	
	public void playGame() {							// if you don't choose wrong, you go to where you choose
		if(beginning) {									// initial starting point to print banner
			beginning = false;
			goTo();
		}
		
		String response = keyboard.nextLine();
		currentRoom = currentRoom.getExit(response);	// you are confined to exits of that room
		
		if(currentRoom == null) {						// if you choose wrong you die
			System.out.println("Uh oh, you're late! And you just got eaten by a Grue. ");
			died = true;
		} else {
			System.out.println("You chose wisely!");
			go(response);
		}
	}

	public void go(String move) {						// description changes depending on room you are in
		if(currentRoom == bed) {
			System.out.println("The bed is so nice. Waking up is not.");
			goTo();
		} else if(currentRoom == house) {
			System.out.println("Couches, kitchen, laptops, netflix... so much to do!");
			goTo();
		} else if(currentRoom == car) {
			System.out.println("But there are so many places you can go! Back home, or to Wendys, to a breakfast diner, or to work... ");
			goTo();
		} else if(currentRoom == work) {
			System.out.println("You made it to the lobby. theres yummy coffee and video games.. \nYou could stay in this lobby all day, or go back to bed...");
			goTo();
		} else if(currentRoom == classroom){
			System.out.println("Class is okay too! Merab makes it fun!");
			finish();									// sets won boolean to true
			
			if(won) {									// if you are in classroom and chose to stay
				System.exit(0); 						// Game exits if you won. change with a boolean
			}
		} else {										// unreachable code?
			System.out.println("You cant go there!");
			goTo();
		}
	}
	
	public boolean died() {								// gets called if you choose incorrectly
		return died;
	}
	
	public void goTo() {								// prints out exits connect to the room you are in
		System.out.println("You can go to: " + currentRoom.getMap().keySet());
	}
	
	public boolean finish() {							// gets called when you enter last room
		System.out.println("Congratualtions! You made it to work! You win.");
		won = true;
		return won;
	}
}