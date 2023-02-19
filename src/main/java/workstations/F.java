package workstations;

import def.Lot;
import def.Micron;
import events.*;
import factory.Factory_Y;

import java.util.ArrayList;

public class F extends Workstation{
  private Factory_Y factory;

  public F(Micron micron){
    super("F", micron.getFactoryY());
    this.factory = micron.getFactoryY();
  }


  //Does Process  4 and 6
  //Accepts Stage 3 and 5
  @Override
  public int getProcessTime(Lot lot) {
    if(lot.getStage() == 3){
      return 10;
    }else if(lot.getStage() == 5){
      return 10;
    }else{
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


      l = checkQueueForLot(lots, 5);
      if(l != null){
        this.setAvail(false);
        return new Event[] {new Stage_Six_Begin(time, l, this)};
      }

      l = checkQueueForLot(lots, 3);
      if(l != null){
        this.setAvail(false);
        return new Event[] {new Stage_Four_Begin(time, l, this)};
      }

      return new Event[0]; //queue does not have lots for A to process.

    }else{
      //not available, so no need to check queue
      return new Event[0];
    }
  }



}
