package factory;

import java.util.ArrayList;
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
            this.lots.add(lots[i]);
        }
    }

    public void addToQueue(ArrayList<Lot> lots){
        for(int i = 0; i < lots.size(); i++){
            this.lots.add(lots.get(i));
        }
    }


    public void addToQueue(Lot lot){
        this.lots.add(lot);
    }


}
