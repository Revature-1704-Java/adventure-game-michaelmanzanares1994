import java.util.*;

public class Game {

	public static void main(String[] args) {
		gameLoop();
	}
	
	public static void gameLoop() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);			
		
		System.out.println("Hello. What is your name?");	
		String playerName = input.nextLine();			
		
		System.out.println("Hi, " + playerName + ".");
		System.out.println("Some tips, any invalid responses will get you kicked off!\nYour responses should be one word. \nAlso, responses are not case sensitive.\n");
		System.out.println("Would you like to play a Game?\nYes or no?\n");

		Play player = new Play(playerName);

		boolean play = input.nextLine().equalsIgnoreCase("yes");
		@SuppressWarnings("unused")
		boolean won = false;
		
		if(play) {
			banner();
		}
		
		while (!player.died() && play) {				// if the player hasn't died and chose to play
			player.playGame();							// abstraction
		}
		System.out.println("Bye, " + playerName + "!");	// prints if you respond "no" and after you die
	}
	
	public static void banner() {
		System.out.println("You started the game! Or is it a nightmarish reality...\nYou wake up from a deep sleep and find yourself in your bed....\nOH NO! You have to get to work in 10 minutes!\n");
	}
}
