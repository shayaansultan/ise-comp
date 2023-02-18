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


    @Override
    public String toString(){
        return name;
    }
}
