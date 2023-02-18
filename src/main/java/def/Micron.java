package def;

import events.Event;
import workstations.Workstation;

import java.util.ArrayList;

public class Micron {

  private static int lots_produced;
  private Workstation[] workstations;
  private Truck truck;


  public Micron(Workstation[] workstations, Truck truck){
    lots_produced = 0;
    this.workstations = workstations;
    this.truck = truck;
  }


  //Returns first event[] returned by workstations
  public Event[] makeWorkstationsCheckQueue(){

    for(Workstation workstation : workstations){

      //fills up the arrayList with events
      Event[] e = workstation.checkQueue();

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
