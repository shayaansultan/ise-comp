package workstations;

import def.Lot;
import def.Micron;
import events.*;
import factory.Factory_Y;

import java.util.ArrayList;

public class D extends Workstation{
  private Factory_Y factory;

  public D(Micron micron){
    super("D", micron.getFactoryY());
    this.factory = micron.getFactoryY();
  }


  //Does Step     1 and 4
  //Accepts Stage 0 and 3
  @Override
  public int getProcessTime(Lot lot) {
    if(lot.getStage() == 0){
      return 5;
    }else if(lot.getStage() == 3){
      return 15;
    }else{
      System.out.println("Error at " + this.workstationId);
      System.exit(420);
      return 1000000000;
    }
  }


  @Override
  public Event[] checkQueue(int time) {

    if(getAvail()){
      //if available then check queue for work
      ArrayList<Lot> lots = factory.getQueue();


      //priority check here
      Lot l = null;

      l = checkQueueForLot(lots, 3);
      if(l != null){
        return new Event[] {new Stage_Four_Begin(time, l, this)};
      }


      l = checkQueueForLot(lots, 0);
      if(l != null) {
        return new Event[]{new Stage_One_Begin(time, l, this)};
      }

      return new Event[0]; //queue does not have lots for A to process.

    }else{
      //not available, so no need to check queue
      return new Event[0];
    }
  }

}
