package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/basicRoom.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	public Robot roomba;

	// You will need to add many variables!!


	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
		Robot roomba = new Robot(9,9,South,9);
		World.setDelay(5);


		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */
roomba = new Robot( startX, startY, East, 0);
		// the line below causes a null pointer exception
		// what is that and why are we getting it?
	int totalBeepersCleaned=0;
		roomba.move();
		roomba.move();
		roomba.pickBeeper();
while (roomba.nextToABeeper())
{
	// body action
	roomba.pickBeeper();
}
for (int i=1; i<=5; i++){
			roomba.move();
			roomba.turnLeft();
			roomba.move();
			roomba.turnLeft();
			roomba.move();
			}
	}

		


		//int totalBeepersCleaned = 0; // Need to move this somewhere else.
        // This method should return the total number of beepers cleaned up.
		return totalBeeperCleaned;
	}
}
