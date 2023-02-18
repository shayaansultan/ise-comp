package events;

import def.Lot;
import workstations.Workstation;

public class Stage_Five_Begin extends Event {
  private Lot lot;
  private Workstation workstation;

  public Stage_Five_Begin(int time, Lot lot, Workstation workstation){
    super(time);

    this.lot = lot;
    this.workstation = workstation;
  }


  @Override
  public Event[] simulate() {
    workstation.setAvail(false);
    int timeEnd = workstation.getProcessTime(lot);

    return new Event[] {new Stage_Five_End(this.getTime() + timeEnd, lot, workstation)};
  }

  @Override
  public String toString(){
    return getTime() + ": " + workstation.toString() + " started " + lot.toString();
  }
}
