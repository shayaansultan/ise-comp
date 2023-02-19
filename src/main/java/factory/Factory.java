package factory;

import java.util.ArrayList;
import java.util.Arrays;

import def.* ;
import workstations.A;

public abstract class Factory {

    private ArrayList<Lot> lots ;
    private String name;

    public Factory(String name){
        this.name = name;
        this.lots = new ArrayList<>();
    }

    public ArrayList<Lot> getQueue(){
        return lots;
    }

    @Override
    public String toString(){
        return name;
    }

    public void addToQueue(Lot[] lots){
        for(int i = 0; i < lots.length; i++){
            if(lots[i] != null) {
                this.lots.add(lots[i]);
            }
        }
    }

    public void printQueue(){
       System.out.println(toString() + ": " + lots.toString());
    }

    public void addToQueue(ArrayList<Lot> lots){
        for(int i = 0; i < lots.size(); i++){
            if(lots.get(i) != null) {
                this.lots.add(lots.get(i));
            }
        }
    }


    public void addToQueue(Lot lot){
        if(lot != null) {
            this.lots.add(lot);
        }
    }


    public boolean queueContains(Lot lot){
        return this.lots.contains(lot);
    }


}
