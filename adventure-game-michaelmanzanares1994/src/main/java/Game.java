import java.util.*;

public class Game {
	static Scanner input = new Scanner(System.in);		// scanner to read in input

	public static void main(String[] args) {
		gameLoop();										// keep main method clean
	}
	
	public static void gameLoop() {
		String playerName = start();
		loop(playerName);
		System.out.println("Bye, " + playerName + "!");	// prints if you respond "no" and after you die
	}
	
	public static String start() {	
		System.out.println("Hello. What is your name?");	
		String playerName = input.nextLine();			
		System.out.println("Hi, " + playerName + ".");		
		System.out.println("Some tips, any invalid responses will get you kicked off!\nYour responses should be one word.\n");
		System.out.println("Would you like to play a Game?\nYes or no?\n");
		return playerName;
	}
	
	public static void loop(String playerName) {
		boolean play = input.nextLine().equalsIgnoreCase("yes");	// if they type yes, play is true. if they type anything else, game exits

		if(play) 										// if needed b/c it would still print out if user said no
			banner();

		Play player = new Play(playerName);				// new Player object
		while (!player.died() && play && !player.exit()) 				// checks the died() every time the player moves from room to room
			player.playGame();							// Player object calls playGame() in a while loop that runs until the died() returns true	
	}
	
	public static void banner() {						// fix banner and fix bed. bed is suppose to kill you when first asked
		System.out.println("You started the game! Or is it a nightmarish reality...\nYou wake up from a deep sleep and find yourself in your bed....\nOH NO! You have to get to work in 10 minutes!\n");
	}
}