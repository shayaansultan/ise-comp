package workstations;

import def.Lot;
import def.Micron;
import events.Event;
import events.Stage_One_Begin;
import events.Stage_Three_Begin;
import factory.Factory;
import factory.Factory_X;

import java.util.ArrayList;

public class A extends Workstation{

  //accepts Stage 0, Stage 2

  //Does process 1 and 2;

  private Factory_X factory;

  public A(Micron micron){
    super("A", micron.getFactoryX());
    this.factory = micron.getFactoryX();
  }


  @Override
  public int getProcessTime(Lot lot) {
    if(lot.getStage() == 0){
      return 5;
    }else if(lot.getStage() == 2){
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

    if(getAvail() == true){
      //if available then check queue for work
      ArrayList<Lot> lots = factory.getQueue();


      //priority check here
      Lot l = null;

      l = checkQueueForLot(lots, 2);
      if(l != null){
        this.setAvail(false);
        return new Event[] {new Stage_Three_Begin(time, l, this)};
      }

      l = checkQueueForLot(lots, 0);
      if(l != null){
        this.setAvail(false);
        return new Event[] {new Stage_One_Begin(time, l, this)};
      }else{
        return new Event[0]; //queue does not have lots for A to process.
      }
    }else{
      //not available, so no need to check queue
       return new Event[0];
    }
  }
}
