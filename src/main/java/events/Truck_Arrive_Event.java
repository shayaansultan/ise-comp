package events;

import def.Lot;
import def.Main;
import def.Truck;

public class Truck_Arrive_Event extends Event{

  private Truck truck;
  private String location;


  public Truck_Arrive_Event(int time, Truck truck, String arrival_location){
    super(time);
    truck.setStatus(arrival_location);
    this.location = arrival_location;
    this.truck = truck;
  }




  @Override
  public Event[] simulate() {

    Lot[] lots = truck.getLots();

    //unload the truck
    if(truck.getStatus().equals("X")){
      Main.micron.getFactoryX().addToQueue(lots);


    }else if(truck.getStatus().equals("Y")){
      Main.micron.getFactoryY().addToQueue(lots);
    }

    //clear the lots in truck
    truck.clearLots();

    //load new lots to truck
    truck.loadLots();

    String destination = "X";

    if(truck.getStatus().equals("X")){
      destination = "Y";
    }else if(truck.getStatus().equals("Y")){
      destination = "X";
    }

    //truck leaves asap
    Truck_Leave_Event leave = new Truck_Leave_Event(getTime(), truck, destination);

    return new Event[] {leave};
  }

  @Override
  public String toString() {
    return getTime() + ": " + "Truck arrived at " + location + " " + truck.toString();
  }

}
