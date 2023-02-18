package def;

import events.Event;
import events.Lot_Created_Event;
import events.Truck_Arrive_Event;
import workstations.E;

public class Simulation {


  private Event[] e;

  /**
   * !TODO
   * Add constructor asking for how many lots to simulate
   */

  public Simulation(int lots){
    e = new Event[lots + 1];
    for(int i = 0; i < lots; i++){
      e[i] = new Lot_Created_Event(0, i);
    }
    e[lots] = new Truck_Arrive_Event(0, Main.micron.getTruck(), "X");
  }


  public Event[] initialize(){
    return e;
  }


}
