package workstations;

import def.Lot;
import def.Micron;
import events.*;
import factory.Factory_X;

import java.util.ArrayList;

public class C extends Workstation{
  private Factory_X factory;

  public C(Micron micron){
    super("C", micron.getFactoryX());
    this.factory = micron.getFactoryX();
  }


  //Does Process  2 and 5
  //Accepts Stage 1 and 4
  @Override
  public int getProcessTime(Lot lot) {
    if(lot.getStage() == 1){
      return 15;
    }else if(lot.getStage() == 4){
      return 10;
    }else{
      System.out.println("Error at " + this.workstationId);
      System.exit(420);
      return 1000000000;
    }
  }


  //belongs to factory X, so checks factoryX's queue
  @Override
  public Event[] checkQueue(int time) {

    if(getAvail()){
      //if available then check queue for work
      ArrayList<Lot> lots = factory.getQueue();


      //priority check here
      Lot l = null;

      l = checkQueueForLot(lots, 1);
      if(l != null){
        return new Event[] {new Stage_Two_Begin(time, l, this)};
      }

      l = checkQueueForLot(lots, 4);
      if(l != null){
        return new Event[] {new Stage_Five_Begin(time, l, this)};
      }

      return new Event[0]; //queue does not have lots for A to process.

    }else{
      //not available, so no need to check queue
      return new Event[0];
    }
  }
}
