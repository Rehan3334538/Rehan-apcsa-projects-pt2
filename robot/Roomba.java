package robot;


import kareltherobot.*;


public class Roomba implements Directions {

   public static void main(String[] args) {
       String worldName = "robot/finalTestWorl2024.wld";


       Roomba cleaner = new Roomba();
       int totalBeepers = cleaner.cleanRoom(worldName, 26, 101);
        System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
   }
   private Robot roomba;
   public int cleanRoom(String worldName, int startX, int startY) {
       World.readWorld(worldName);
       World.setVisible(true);
       World.setDelay(0);


       roomba = new Robot(startX, startY, East, 0);
       int count = 0;
       int numPiles = 0;
       int numSteps = 0;
       boolean end = true;
       while(end){
           while(roomba.nextToABeeper()){
                   roomba.pickBeeper();
                   count++;
               }
           while(roomba.frontIsClear()){
               roomba.move();
               numSteps++;
               if(roomba.nextToABeeper() == true){
                   numPiles++;
               }
               while(roomba.nextToABeeper()){
                   roomba.pickBeeper();
                   count++;
               }
           }
           if(roomba.facingEast() && !roomba.frontIsClear()){
               while(roomba.nextToABeeper()){
                   roomba.pickBeeper();
                   count++;
               }
               roomba.turnLeft();
               roomba.move();
               numSteps++;
               while(roomba.nextToABeeper()){
                   roomba.pickBeeper();
                   count++;
               }
               roomba.turnLeft();
           }
           if(roomba.facingWest() && !roomba.frontIsClear()){
               while(roomba.nextToABeeper()){
                   roomba.pickBeeper();
                   count++;
               }
               turnRight(roomba);
               roomba.move();
               numSteps++;
               while(roomba.nextToABeeper()){
                   roomba.pickBeeper();
                   count++;
               }
               turnRight(roomba);
           }
           if(roomba.facingNorth() && !roomba.frontIsClear()){
               end = false;
           }
       }
       System.out.println("Total number of beepers: "+ count);
       System.out.println("Dirty percentage: "+ (double)numPiles/numSteps +"%");
       System.out.println("Average pile size: "+ (double)count/numPiles);
       System.out.println("Area: "+numSteps);
       System.out.println("Total number of piles: "+ numPiles);
       return count;
   }
   public static void turnRight(Robot roomba){
       roomba.turnLeft();
       roomba.turnLeft();
       roomba.turnLeft();
   }
}
 
