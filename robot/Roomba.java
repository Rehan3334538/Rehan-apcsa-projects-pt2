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
		Robot romba = new Robot(9,9,South,9);
		World.setDelay(1);


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
		for (int i=1; i<=7; i++) {
			if (roomba.nextToABeeper()) {
				roomba.pickBeeper();
				totalBeepersCleaned++;
			}
		}
roomba.move();
	for (int i=1; i<=6; i++){
			if (roomba.nextToABeeper()) {
				roomba.pickBeeper();
				totalBeepersCleaned++;
			}
		}
		roomba.move();
		roomba.move();
		roomba.turnLeft();
		roomba.move();
			for (int i=1; i<=6; i++){
			if (roomba.nextToABeeper()) {
				roomba.pickBeeper();
				totalBeepersCleaned++;
			}
		}
		roomba.move();
			for (int i=1; i<=13; i++){
			if (roomba.nextToABeeper()) {
				roomba.pickBeeper();
				totalBeepersCleaned++;
			}
		}
		roomba.turnLeft();
		roomba.move();
roomba.move();
roomba.move();
roomba.move();
	for (int i=1; i<=6; i++){
			if (roomba.nextToABeeper()) {
				roomba.pickBeeper();
				totalBeepersCleaned++;
			}
		}
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.move();
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.turnLeft();
	   roomba.move();
	   roomba.move();
	   	for (int i=1; i<=7; i++){
			if (roomba.nextToABeeper()) {
				roomba.pickBeeper();
				totalBeepersCleaned++;
			}
		}
		roomba.move();
		roomba.move();
		roomba.move();
	 roomba.move();
	 roomba.turnLeft();
	 roomba.move();
	 	for (int i=1; i<=6; i++){
			if (roomba.nextToABeeper()) {
				roomba.pickBeeper();
				totalBeepersCleaned++;
			}
		}
		roomba.turnLeft();
		roomba.move();
		roomba.move();
		roomba.move();
			for (int i=1; i<=6; i++){
			if (roomba.nextToABeeper()) {
				roomba.pickBeeper();
				totalBeepersCleaned++;
			}
		}
		roomba.move();
		roomba.move();
			for (int i=1; i<=5; i++){
			if (roomba.nextToABeeper()) {
				roomba.pickBeeper();
				totalBeepersCleaned++;
			}
		}
		roomba.move();


		
		


		int totalBeepers = 0; // Need to move this somewhere else.
        // This method should return the total number of beepers cleaned up.
		return totalBeepers;
	}
}
