package workstations;

import def.Lot;
import def.Micron;
import events.Event;
import events.Stage_Five_Begin;
import events.Stage_One_Begin;
import events.Stage_Three_Begin;
import factory.Factory_Y;

import java.util.ArrayList;

public class E extends Workstation{
  private Factory_Y factory;

  public E(Micron micron){
    super("E", micron.getFactoryY());
    this.factory = micron.getFactoryY();
  }

  //Does process  1, 3 and 5
  // Accept stage 0, 2 and 4
  @Override
  public int getProcessTime(Lot lot) {
    if(lot.getStage() == 0){
      return 5;
    }else if(lot.getStage() == 2){
      return 5;
    }else if (lot.getStage() == 4){
      return 15;
    }
    else{
      System.out.println("Error at " + this.workstationId);
      System.exit(420);
      return 1000000000;
    }
  }

  @Override
  public synchronized Event[] checkQueue(int time) {

    if(getAvail()){
      //if available then check queue for work
      ArrayList<Lot> lots = factory.getQueue();


      //priority check here
      Lot l = null;

      l = checkQueueForLot(lots, 4);
      if(l != null){
        this.setAvail(false);
        return new Event[] {new Stage_Five_Begin(time, l, this)};
      }

      l = checkQueueForLot(lots, 2);
      if(l != null){
        this.setAvail(false);
        return new Event[] {new Stage_Three_Begin(time, l, this)};
      }

      l = checkQueueForLot(lots, 0);
      if(l != null){
        this.setAvail(false);
        return new Event[] {new Stage_One_Begin(time, l, this)};
      }

      return new Event[0]; //queue does not have lots for A to process.

    }else{
      //not available, so no need to check queue
      return new Event[0];
    }
  }
}
