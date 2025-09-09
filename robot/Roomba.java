package robot;

import kareltherobot.*;

public class Roomba implements Directions{
public static void main(String[] args){
String worldName="robot/basicRoom.wld";
Roomba r=new Roomba();
r.cleanRoom(worldName,7,6);
}
public Robot roomba;
public int cleanRoom(String worldName,int startX,int startY){
World.readWorld(worldName);
World.setVisible(true);
World.setDelay(5);
roomba=new Robot(startX,startY,East,0);
int rows=0;
for(rows=0;rows<5;rows++){
while(roomba.frontIsClear()){
while(roomba.nextToABeeper()){
roomba.pickBeeper();
}
roomba.move();
}
while(roomba.nextToABeeper()){
roomba.pickBeeper();
}
if(rows==4){
return 0;
}
if(roomba.facingEast()){
roomba.turnLeft();
if(roomba.frontIsClear()){
roomba.move();
roomba.turnLeft();
}
}else{
roomba.turnLeft();
roomba.turnLeft();
roomba.turnLeft();
if(roomba.frontIsClear()){
roomba.move();
roomba.turnLeft();
roomba.turnLeft();
roomba.turnLeft();
}
}
}
return 0;
}
}