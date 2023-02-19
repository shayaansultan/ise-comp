package def;

import events.Event;
import factory.Factory_X;
import factory.Factory_Y;
import workstations.*;

import java.util.ArrayList;

public class Micron {

  private static int numb_lots_produced;
  private Workstation[] workstations;
  private Truck truck;

  private ArrayList<Lot> lots_completed;


  public void addCompletedLot(Lot lot){
    lots_completed.add(lot);
  }

  public void printCompleted(){
    System.out.println("Completed: " + lots_completed.toString());
  }


  private Factory_X factoryX;
  private Factory_Y factoryY;

  public Micron(Truck truck, Factory_X x, Factory_Y y){
    numb_lots_produced = 0;
    this.truck = truck;
    this.factoryX = x;
    this.factoryY = y;
    this.lots_completed = new ArrayList<Lot>();

    this.workstations = new Workstation[] {new A(this),
            new B(this),
            new C(this),
            new D(this),
            new E(this),
            new F(this)};
  }


  public Truck getTruck(){
    return this.truck;
  }

  public Factory_X getFactoryX() {
    return factoryX;
  }

  public Factory_Y getFactoryY() {
    return factoryY;
  }


  //Returns first event[] returned by workstations
  public Event[] makeWorkstationsCheckQueue(int time){

    //checkForceTermination();


    for(Workstation workstation : workstations){

      if(workstation.getAvail() == true){
        //fills up the arrayList with events
        Event[] e = workstation.checkQueue(time);

        if(e.length != 0){
          //System.out.println("Found viable lot in queue for " + workstation.toString());
          return e; //return the first event trigger
        }
      }else{
        //do nothing if workstation is not available.
      }

    }
    //if no events to generate, just send back empty event
    return new Event[0];
  }


  //redundant function for forcing termination
  private void checkForceTermination(){
    boolean bool = factoryX.getQueue().size() == 0 && factoryY.getQueue().size() == 0;

//    Lot[] lots = truck.getLots();
//    for(Lot l : lots){
//      bool = bool && (l == null);
//    }

    if(bool){
      System.exit(68);
    }
  }


  public static void incrementLotsProduced(){
    numb_lots_produced = numb_lots_produced + 1;
  }

  public static int getNumb_lots_produced(){
    return numb_lots_produced;
  }

}
