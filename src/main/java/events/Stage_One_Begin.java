package events;

import def.Lot;
import def.Main;
import workstations.Workstation;

public class Stage_One_Begin extends Event {

  private Lot lot;
  private Workstation workstation;

  public Stage_One_Begin(int time, Lot lot, Workstation workstation){
    super(time);

    this.lot = lot;
    this.workstation = workstation;
  }


  @Override
  public Event[] simulate() {

    workstation.removeLotFromQueue(lot);
    workstation.setAvail(false);
    int timeEnd = workstation.getProcessTime(lot);


    Event[] c = Main.micron.makeWorkstationsCheckQueue(getTime());
    Event[] e = new Event[] {new Stage_One_End(this.getTime() + timeEnd, lot, workstation)};

    return mergeEvents(c, e);
  }

  @Override
  public String toString(){
    return getTime() + ": " + workstation.toString() + " started " + lot.toString();
  }
}
