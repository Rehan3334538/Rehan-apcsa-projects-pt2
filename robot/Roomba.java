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

    public int cleanRoom(String worldName, int startX, int startY) {

        World.readWorld(worldName);
        World.setVisible(true);
        World.setDelay(5);

        // Use instance variable instead of local declaration
        roomba = new Robot(startX, startY, East, 0);
        int totalBeepersCleaned = 0;
      while (roomba.frontIsClear())
{
while (roomba.nextToABeeper())
{
	roomba.pickBeeper();
}
	roomba.move();
}
roomba.turnLeft();
while (roomba.frontIsClear())
{
while (roomba.nextToABeeper())
{
	roomba.pickBeeper();
}
	roomba.move();
}
roomba.turnLeft();
while (roomba.frontIsClear())
{
while (roomba.nextToABeeper())
{
	roomba.pickBeeper();
}
	roomba.move();
}
roomba.turnLeft();
roomba.move();
roomba.turnLeft();
while (roomba.frontIsClear())
{
while (roomba.nextToABeeper())
{
	roomba.pickBeeper();
}
	roomba.move();
}
roomba.turnLeft();
roomba.turnLeft();
roomba.turnLeft();
roomba.move();
roomba.turnLeft();
roomba.turnLeft();
roomba.turnLeft();
while (roomba.frontIsClear())
{
while (roomba.nextToABeeper())
{
	roomba.pickBeeper();
}
	roomba.move();
}
roomba.turnLeft();
roomba.move();
roomba.turnLeft();
while (roomba.frontIsClear())
{
while (roomba.nextToABeeper())
{
	roomba.pickBeeper();
}
	roomba.move();
}


        return totalBeepersCleaned;
    }
}