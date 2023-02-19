package workstations;

import def.Lot;
import events.Event;
import factory.Factory;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public abstract class Workstation {
    protected String workstationId ;
    private boolean status;
    private Factory factory;
    

    public Workstation(String id, Factory factory) {
        this.workstationId = id ;
        this.factory = factory;
        this.status = true;
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
        factory.printQueue();

        boolean b;
        do {
            b = factory.getQueue().remove(lot);
        }while (b);


        System.out.println("REMOVED " + lot + " from QUEUE ");
        factory.printQueue();

    }

    //!TODO cheated here tbh
    public void addLotToQueue(Lot lot){
        factory.printQueue();
        factory.getQueue().add(lot);
        System.out.println("ADDED " + lot + " to QUEUE ");
        factory.printQueue();
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


    public boolean checkForLotAvailibility(Lot lot){
        return this.factory.queueContains(lot);
    }

}
