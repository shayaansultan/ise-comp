package events;

import def.Truck;

import javax.sound.sampled.FloatControl;

public class Truck_Leave_Event extends Event {

  private Truck truck;
  private String destination;
  private String location;


  public Truck_Leave_Event(int time, Truck truck, String destination){
    super(time);
    this.truck = truck;
    this.destination = destination;
    this.location = truck.getStatus();
  }

  @Override
  public Event[] simulate() {
    truck.loadLots();
    truck.setStatus("T");

    return new Event[] {new Truck_Arrive_Event(getTime() + 25, truck, destination)};
  }

  @Override
  public String toString() {
    return getTime() + ": " + "Truck departed " + location + " " + truck.toString();
  }
}
