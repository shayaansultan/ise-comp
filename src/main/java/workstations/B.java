package workstations;

import def.Lot;
import def.Micron;
import events.*;
import factory.Factory_X;

import java.util.ArrayList;

public class B extends Workstation{

  private Factory_X factory;


  public B(Micron micron){
    super("B", micron.getFactoryX());
    this.factory = micron.getFactoryX();
  }



  //Does Process  2 and 6
  //Accepts Stage 1 and 5
  @Override
  public int getProcessTime(Lot lot) {
    if(lot.getStage() == 1){
      return 15;
    }else if(lot.getStage() == 5){
      return 10;
    }else{
      System.out.println("Error at " + this.workstationId);
      System.exit(420);
      return 1000000000;
    }
  }


  //belongs to factory X, so checks factoryX's queue
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

      l = checkQueueForLot(lots, 1);
      if(l != null){
        this.setAvail(false);
        return new Event[] {new Stage_Two_Begin(time, l, this)};
      }else{
        return new Event[0]; //queue does not have lots for A to process.
      }
    }else{
      //not available, so no need to check queue
      return new Event[0];
    }
  }

}
