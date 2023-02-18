package events;

import def.Lot;
import workstations.Workstation;

public class Stage_Three_End extends Event {
  private Lot lot;
  private Workstation workstation;

  public Stage_Three_End(int time, Lot lot, Workstation workstation){
    super(time);

    this.lot = lot;
    this.workstation = workstation;
  }


  @Override
  public Event[] simulate() {
    return new Event[0];
  }
}
