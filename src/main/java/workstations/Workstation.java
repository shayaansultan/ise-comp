package workstations;

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

    public abstract Event[] checkQueue() ;


}
