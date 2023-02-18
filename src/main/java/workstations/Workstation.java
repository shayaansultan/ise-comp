package workstations;

import def.Lot;
import events.Event;
import factory.Factory;

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

    public abstract Event[] checkQueue();

    public abstract void removeLotFromQueue(Lot lot);

    public abstract void addLotToQueue(Lot lot);
}
