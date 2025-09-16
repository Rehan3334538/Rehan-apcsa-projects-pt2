package robot;

import kareltherobot.*;

public class Roomba implements Directions {
    public Robot roomba;

    public static void main(String[] args) {
        String worldName = "robot/finalTestWorld2024.wld";
        Roomba r = new Roomba();
        r.cleanRoom(worldName, 26, 101);
    }

    public int cleanRoom(String worldName, int startX, int startY) {
        World.readWorld(worldName);
        World.setVisible(true);
        World.setDelay(0);
        roomba = new Robot(startX, startY, East, 0);

        int maxPile = 0;
        int total = 0;
        int maxStreet = startX;
        int maxAvenue = startY;
        for (int rows = 0; rows < 5; rows++) {
            while (roomba.frontIsClear()) {
                int pile = 0;
                while (roomba.nextToABeeper()) {
                    roomba.pickBeeper();
                    pile++;
                    total++;
                }
                if (pile > 0) System.out.println("Average pile size: " + pile);
                if (pile > maxPile) {
                    maxPile = pile;
                    maxStreet = roomba.street();
                    maxAvenue = roomba.avenue();
                }
                roomba.move();
            }
            int pile = 0;
            while (roomba.nextToABeeper()) {
                roomba.pickBeeper();
                pile++;
                total++;
            }
            if (pile > 0) System.out.println("Average pile size: " + pile);
            if (pile > maxPile) {
                maxPile = pile;
                maxStreet = roomba.street();
                maxAvenue = roomba.avenue();
            }
            if (rows == 4) {
                System.out.println("Largest pile: " + maxPile);
                System.out.println("Location of largest pile: Street " + maxStreet + ", Avenue " + maxAvenue);
                System.out.println("Total beepers: " + total);
                return total;
            }
            if (roomba.facingEast()) {
                roomba.turnLeft();
                if (roomba.frontIsClear()) {
                    roomba.move();
                    roomba.turnLeft();
                }
            } else {
                roomba.turnLeft();
                roomba.turnLeft();
                roomba.turnLeft();
                if (roomba.frontIsClear()) {
                    roomba.move();
                    roomba.turnLeft();
                    roomba.turnLeft();
                    roomba.turnLeft();
                }
            }
        }
        System.out.println("Largest pile: " + maxPile);
        System.out.println("Location of largest pile: Street " + maxStreet + ", Avenue " + maxAvenue);
        System.out.println("Total beepers: " + total);
        return total;
    }
}