package workstations;

import def.Lot;
import events.Event;
import factory.Factory;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public abstract class Workstation {
    private String workstationId ;
    private boolean status = true ;
    private Factory factory;
    

    public Workstation(String id, Factory factory) {
        this.workstationId = id ;
        this.factory = factory;
    }
    
    public void setAvail(boolean c) {
        this.status = c;
    }

    public boolean getAvail() {
        return this.status;
    }

    @Override
    public String toString() {
        return this.workstationId ;
    }

    public abstract int getProcessTime(Lot lot);

    public abstract Event[] checkQueue(int time);

    public void removeLotFromQueue(Lot lot){
        factory.getQueue().remove(lot);
    }

    public void addLotToQueue(Lot lot){
        factory.getQueue().add(lot);
    }

    protected @Nullable
    Lot checkQueueForLot(ArrayList<Lot> queue, int stage){
    for(Lot elem : queue){
        if(elem.getStage() == stage){
            return elem;
        }
    }
    return null;
    }
}
