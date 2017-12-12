package org.games.adventure.blueprint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import org.games.adventure.*;

public class Room{
    protected String name;
    protected String desc;
    protected ArrayList<String> items = new ArrayList<>();
    //private ArrayList<Entity> entities = new ArrayList<>();

    //protected ArrayList<String> contents= new ArrayList<String>();
    //protected int contentsize;

    private boolean visited = false;


    private String[] exits= new String[6];

    /*public void AddContent(String item){
        ontentsize++;
        contents.add(item);
    }

    */

    //public abstract int commandMe(String command);

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setDesc(String desc){
        this.desc=desc;
    }

    public String getDesc(){
        return desc;
    } 

    public void addAction(String action){
        items.add(action);
    }

    public void look(){
        System.out.println(desc);
    }

    public ArrayList<String> getActions(){
        return items;
    }

   /*public void setExit(int numOfExit,int exit){
        this.exits[numOfExit]=exit;
    }*/

    public void setExit(int exit, String room){

        this.exits[exit] = room;
    }

    public int visiting(){
        if(visited==true)
        {
            return 0;
        }

        else{
            visited=true;
            return 1;
        }
    }

    public void checkExits(String exit){
        boolean invalid=false;
        switch(exit){
            case "north" : {
                if(exits[0]!=null & !(exits[0].equals(""))){
                    System.out.println("You go north into the " + exits[0]);
                    GameController.changeRoom(exits[0]);
                } 
                else invalid=true;
            }break;

            case "east" :{
                if(exits[1]!=null & !(exits[1].equals(""))){
                    System.out.println("You go north into the " + exits[1]); 
                    GameController.changeRoom(exits[1]);
                } 
                else invalid=true;
            }break;

            case "south" :{
                if(exits[2]!=null & !(exits[2].equals(""))){
                    System.out.println("You go north into the " + exits[2]); 
                    GameController.changeRoom(exits[2]);
                } 
                else invalid=true;
            }break;

            case "west" :{
                if(exits[3]!=null & !(exits[3].equals(""))){
                    System.out.println("You go north into the " + exits[3]); 
                    GameController.changeRoom(exits[3]);
                } 
                else invalid=true;
            }break;

            case "up" :{
                if(exits[4]!=null & !(exits[4].equals(""))){
                    System.out.println("You go north into the " + exits[4]); 
                    GameController.changeRoom(exits[4]);
                } 
                else invalid=true;
            }break;
            
            case "down"  :            {
                if(exits[5]!=null & !(exits[5].equals(""))){
                    System.out.println("You go north into the " + exits[5]); 
                    GameController.changeRoom(exits[5]);
                } 
                else invalid=true;
            } break;

            default: invalid=true;
        }

        if(invalid) System.out.println("Invalid command");
    }

    public void printOut(){
        System.out.println(name);
        System.out.println(desc);
        System.out.println(items);
        System.out.println(Arrays.toString(exits));
    }

    public void describe(){
        System.out.print("Around the room you can see a\n");
        for(int i = 0; i<items.size();i++){
            if (i==0) System.out.print(items.get(i));
            else  System.out.print(", a" + items.get(i));
        }
        System.out.print(".\n");

        if(exits[0]!=null) System.out.println("To the north is " + exits[0] + ".");
        if(exits[1]!=null) System.out.println("To the east is " + exits[1] + ".");
        if(exits[2]!=null) System.out.println("To the south is " + exits[2] + ".");
        if(exits[3]!=null) System.out.println("To the west is " + exits[3] + ".");
        if(exits[4]!=null) System.out.println("Up above is " + exits[4] + ".");
        if(exits[5]!=null) System.out.println("Below is " + exits[5] + ".");
    }


}