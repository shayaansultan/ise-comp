package workstations;

import def.Lot;
import events.Event;

public abstract class Workstation {
    private String workstationId ;
    private boolean status = true ;
    

    public Workstation(String id) {
        this.workstationId = id ;
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
