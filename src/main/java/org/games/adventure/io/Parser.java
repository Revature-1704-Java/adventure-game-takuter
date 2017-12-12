package org.games.adventure.io;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import org.games.adventure.blueprint.*;

public class Parser{

    public void readCommand(String command, Room room, ArrayList<Item> items){
        int objCom = -1;
        String commands[] = command.split(" ");
        boolean objExists = false;
        if(commands.length>1){
            for(int i=0;i<items.size() ; i++ ){
                if(items.get(i).getName().equals(commands[0])) items.get(i).searchAction(commands[1]);
                if(items.get(i).getName().equals(commands[1])) items.get(i).searchAction(commands[0]);
            }
            
            if(objCom==-1){
                if(commands[1].equals("go")) room.checkExits(commands[0]);
                else if(commands[0].equals("go")) room.checkExits(commands[1]);
            }
        
        }
        else System.out.println("Invalid command");
    
}
    
}