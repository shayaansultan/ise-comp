package events;

import def.Lot;
import def.Main;
import workstations.Workstation;

public class Stage_One_End extends Event {

  private Lot lot;
  private Workstation workstation;

  public Stage_One_End(int time, Lot lot, Workstation workstation){
    super(time);

    this.lot = lot;
    this.workstation = workstation;
  }


  @Override
  public Event[] simulate() {
    workstation.setAvail(true);
    lot.setStage(1);
    workstation.addLotToQueue(lot);

    return Main.micron.makeWorkstationsCheckQueue(getTime());
  }

  @Override
  public String toString(){
    return getTime() + ": " + workstation.toString() + " ended " + lot.toString();
  }
}
