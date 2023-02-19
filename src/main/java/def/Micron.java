package def;

import events.Event;
import factory.Factory;
import factory.Factory_X;
import factory.Factory_Y;
import workstations.*;

import java.util.ArrayList;

public class Micron {

  private static int lots_produced;
  private Workstation[] workstations;
  private Truck truck;

  private Factory_X factoryX;
  private Factory_Y factoryY;

  public Micron(Truck truck, Factory_X x, Factory_Y y){
    lots_produced = 0;
    this.truck = truck;
    this.factoryX = x;
    this.factoryY = y;

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

    //checkTermination();


    for(Workstation workstation : workstations){

      if(workstation.getAvail()){
        //fills up the arrayList with events
        Event[] e = workstation.checkQueue(time);

        if(e.length != 0){
          return e; //return the first event trigger
        }
      }

    }
    //if no events to generate, just send back empty event
    return new Event[0];
  }


  private void checkTermination(){
    boolean bool = factoryX.getQueue().size() == 0 && factoryY.getQueue().size() == 0;

//    Lot[] lots = truck.getLots();
//    for(Lot l : lots){
//      bool = bool && (l == null);
//    }

    if(bool){
      System.exit(1);
    }
  }


  public static void incrementLotsProduced(){
    lots_produced = lots_produced + 1;
  }

  public static int getLots_produced(){
    return lots_produced;
  }

}
