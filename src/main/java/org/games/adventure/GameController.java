package org.games.adventure;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import org.games.adventure.blueprint.*;
import org.games.adventure.io.*;

public class GameController{
    private static HashMap<String, Room> rooms;
    private static Parser comms = new Parser();
    private static Room currentRoom = null;
    private static ArrayList<Item> items;

    private static int visitedRoom = 0;
    //private Inventory inv = new Inventory();

    public static void main(String[] args){
        boolean completed = false   ;
        Scanner sc = new Scanner(System.in);
        buildGame(args);

        while(!completed){
            System.out.println("What would you like to do?");
            String command = sc.nextLine();
            if(command.equals("exit")){
                if(visitedRoom>=rooms.size()){
                    System.out.println("Hope you enjoyed your gameplay experience");
                    completed=true;
                }
                else System.out.println("You have not visited all the rooms yet.");
            }
            else if(command.equals("quit")){
                completed=true;
                System.out.println("Thank you for playing");
            }
            else comms.readCommand(command, currentRoom, items);
        }
    }

    private static void buildGame(String[] files){
        rooms = Depackage.depackageRooms(files[0]);
        items = Depackage.depackageItems(files[1]);
    }

    public static void changeRoom(String room){
        visitedRoom += currentRoom.visiting();
        room= room.replaceAll("(\\r|\\n)", "");
        currentRoom = rooms.get(room);
        currentRoom.describe();
    }

    public static void startingRoom(Room room){
        currentRoom=room;
        currentRoom.describe();
    }

}