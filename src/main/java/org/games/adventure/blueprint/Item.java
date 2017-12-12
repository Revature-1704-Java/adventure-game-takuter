package org.games.adventure.blueprint;

import java.util.ArrayList;

public class Item{
    protected String name = null;
    protected String desc = null;
    protected String used = null;
    protected ArrayList<String> actions = new ArrayList<>();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc){
        this.desc= desc;
    }

    public ArrayList<String> getActions(){
        return actions;
    }

    public void addAction(String action){
        actions.add(action);
    }

    public void searchAction(String action){
        switch (action)
        {
            case "examine" : investigate(); break;
            case "use" : use(); break;
            case "take" : take(); break;
            default : invalidCommand();
        }
    }

    protected void investigate(){
        if(desc != null) System.out.println(desc);
        else invalidCommand();
    }

    protected void use(){
        if(used != null) System.out.println(used);
        else invalidCommand();
    }

    protected void take(){
        invalidCommand();
    }

    protected void invalidCommand(){
        System.out.println("Invalid Command");
    }

    public boolean hasCommand(String action){
        boolean command=false;
        for(int i=0;i<actions.size();i++){
            if(actions.get(i).equals(action)) command=true;
        }
        return command;
    }

}