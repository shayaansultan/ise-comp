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

  public Event[] makeWorkstationsCheckQueue(){

    ArrayList<Event> events = new ArrayList<>();
    for(Workstation workstation : workstations){

      //fills up the arrayList with events
      Event[] e = workstation.checkQueue();
      for(int i = 0; i < e.length; i++){
        events.add(e[i]);
      }
    }

    return ArrayListToArray(events);
  }


  private Event[] ArrayListToArray(ArrayList<Event> ev){
    Event[] events = new Event[ev.size()];

    for(int i = 0; i < ev.size(); i++){
      events[i] = ev.get(i);
    }
    return events;
  }


  public static void incrementLotsProduced(){
    lots_produced = lots_produced + 1;
  }


}
