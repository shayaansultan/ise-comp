package def;

import events.Event;
import events.Lots_Initiated;
import events.Truck_Arrive_Event;

public class Simulation {


  private Event[] e;

  /**
   * !TODO
   * Add constructor asking for how many lots to simulate
   */

  private int lots;

  public int getLots(){
    return lots;
  }

  private Micron micron;

  public Micron getMicron(){
    return micron;
  }

  public Simulation(int lots, Micron micron){
    this.lots = lots;
    this.micron = micron;

    for(int i = 0; i < lots; i++){
      micron.getFactoryX().addToQueue(new Lot(i, 0, "X"));
    }


    e= new Event[] {new Lots_Initiated(0, micron), new Truck_Arrive_Event(0, micron.getTruck(), "X")};

  }


  public Event[] initialize(){
    return e;
  }


}
