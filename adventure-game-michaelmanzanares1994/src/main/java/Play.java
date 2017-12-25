import java.util.*;

public class Play {
	Scanner keyboard = new Scanner(System.in);			// access user input
	private boolean died = false;						// died flag
	private boolean won = false;						// exit flag for when you win
	
	private LocationBean currentRoom;
	private LocationBean bed		= new LocationBean("bed");	// create locations. can have as many as you want
	@SuppressWarnings("unused")
	private LocationBean kitchen 	= new LocationBean("kitchen");
	private LocationBean house		= new LocationBean("house");
	private LocationBean car		= new LocationBean("car");
	@SuppressWarnings("unused")
	private LocationBean wendys		= new LocationBean("wendys");	
	@SuppressWarnings("unused")
	private LocationBean diner		= new LocationBean("diner");
	private LocationBean work		= new LocationBean("work");
	private LocationBean classroom	= new LocationBean("classroom");
	@SuppressWarnings("unused")
	private LocationBean lobby 		= new LocationBean("lobby");

	public Play(String playerName) {					// constructor
		currentRoom = bed;								// create starting location

		bed.setExit("car", car);						// create exits to each room
		bed.setExit("bed", null);						// able to create any new exit location easily
		bed.setExit("kitchen", null);

		house.setExit("house", null);					// null represents a wrong choice and death
		house.setExit("car", car);
		
		car.setExit("house", null);
		car.setExit("work", work);
		car.setExit("wendys", null);
		car.setExit("diner", null);

		work.setExit("car", null);
		work.setExit("classroom", classroom);
		work.setExit("lobby", null);
	}
	
	public void playGame() {							// take user input and checks to see if its a valid location to move to
		if(currentRoom == classroom) {
			exit();
		}
		goTo();											// console logs the rooms you can choose between
		
		String response = keyboard.nextLine();
		currentRoom = currentRoom.getExit(response);	// takes in key string and returns value room. all but one value is null
		
		if(currentRoom == null) {						// if the room you chose to go to is null, you die
			System.out.println("Uh oh, now you're late! And you just got eaten by a Grue. ");
			died = true;
		} else if(currentRoom == classroom) {
			System.out.println("Congratulations! You made it to work! You won the game.");
			won = true;
		}     else {
			System.out.println("You chose wisely!");	// this gets printed, then programs moves back to while loop
		}
	}

	public void go(String move) {						// description changes depending on room you are in. only the rooms you are allowed to go to have descriptions
		if(currentRoom == car) {
			System.out.println("But there are so many places you can go! Back home, or to Wendys, to a breakfast diner, or to work... ");
			goTo();										// show exits available
		} else if(currentRoom == work) {
			System.out.println("You made it to the lobby. theres yummy coffee and video games.. \nYou could stay in this lobby all day, or go back home to bed...");
			goTo();
		} 
	}
	
	public void goTo() {								// prints out exits connect to the room you are in
		System.out.println("You can choose between: " + currentRoom.getMap().keySet());
	}
	
	public boolean died() {								// gets called if you choose incorrectly
		return died;
	}
	
	public boolean exit() {
		return won;
	}
}