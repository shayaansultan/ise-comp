package def;

import events.Event;
import factory.Factory;
import factory.Factory_X;
import factory.Factory_Y;
import workstations.Workstation;

import java.util.ArrayList;

public class Micron {

  private static int lots_produced;
  private Workstation[] workstations;
  private Truck truck;

  private Factory_X factoryX;
  private Factory_Y factoryY;

  public Micron(Workstation[] workstations, Truck truck, Factory_X x, Factory_Y y){
    lots_produced = 0;
    this.workstations = workstations;
    this.truck = truck;
    this.factoryX = x;
    this.factoryY = y;
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

    for(Workstation workstation : workstations){

      //fills up the arrayList with events
      Event[] e = workstation.checkQueue(time);

      if(e.length != 0){
        return e; //return the first event trigger
      }else{
        //do nothing
      }
    }
    //if no events to generate, just send back empty event
    return new Event[0];
  }



  public static void incrementLotsProduced(){
    lots_produced = lots_produced + 1;
  }


}
