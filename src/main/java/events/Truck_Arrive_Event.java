package events;

import def.Lot;
import def.Truck;

public class Truck_Arrive_Event extends Event{

  private Truck truck;


  public Truck_Arrive_Event(int time, Truck truck, String location){
    super(time);
    truck.setStatus(location);

    Lot[] lots = truck.getLots();

  }




  @Override
  public Event[] simulate() {




    return new Event[0];
  }
}
