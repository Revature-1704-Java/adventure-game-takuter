package org.games.adventure.io;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import org.games.adventure.blueprint.*;
import org.games.adventure.*;

public class Depackage{

    public static HashMap<String, Room> depackageRooms(String file){

        HashMap<String, Room> rooms = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            
            int numOfRoom=br.read() - '0';
            br.readLine();
            br.readLine();

            for(int i=0; i < numOfRoom; i++){
                Room temproom=new Room();
                temproom.setName(br.readLine());
                temproom.setDesc(br.readLine());

                int limiter = br.read()  - '0';
                for(int j=0; j < limiter;j++)
                {
                    if (j==0) br.readLine();
                    temproom.addAction(wordBuilder(br));
                }

                limiter = br.read()  - '0';
                
                for(int j=0;j < limiter;j++)
                {
                    if (j==0) br.readLine();
                    temproom.setExit(j, wordBuilder(br));
                }



                br.readLine();
                
                rooms.put(temproom.getName(), temproom);
                System.out.println(rooms.get(temproom.getName()).getName());
                if(i==0) GameController.startingRoom(temproom);
                
            }
        } catch(FileNotFoundException ex){ ex.getMessage(); 
        } catch(IOException ex){ ex.getMessage(); }
        return rooms;
    }

    public static ArrayList<Item> depackageItems(String file){
        ArrayList<Item> items = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            int numOfItems=br.read() - '0';
            br.readLine();
            br.readLine();


            for( int i=0;i<numOfItems;i++){
                String itemType = br.readLine();

                Item tempitem = initializeItem(itemType);
                tempitem.setName(br.readLine());
                tempitem.setDesc(br.readLine());

                int limiter = (int)br.read() - '0';

                for(int j=0;j < limiter;j++)
                {
                    if (j==0) br.readLine();
                    tempitem.addAction(wordBuilder(br));
                }

                items.add(tempitem);
                br.readLine();
            }
        } catch(FileNotFoundException ex){ ex.getMessage(); 
        } catch(IOException ex){ ex.getMessage(); }

        return items;
    }

    protected static Item initializeItem(String type){
        Item item;
        switch(type){
            default : item = new Item();
        }
        return item;
    }

    public static String wordBuilder(BufferedReader br) throws IOException{
        char c;
        boolean comma=false;
        StringBuffer temp = new StringBuffer();
        while(!comma){
            c = (char)br.read();
            if(c==',' | c== '\n' ) {
                comma=true;
            }

            else if(c!= ' '){

                temp.append(c);
            }
        }   

        return temp.toString();
    }
}