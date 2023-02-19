package events;

import def.Lot;
import def.Main;
import workstations.Workstation;

public class Stage_Two_Begin extends Event {
  private Lot lot;
  private Workstation workstation;

  public Stage_Two_Begin(int time, Lot lot, Workstation workstation){
    super(time);

    this.lot = lot;
    this.workstation = workstation;
  }


  @Override
  public Event[] simulate() {

    if(workstation.checkForLotAvailibility(lot) == true && workstation.getAvail()) {

      workstation.setAvail(false);
      workstation.removeLotFromQueue(lot);
      int timeEnd = workstation.getProcessTime(lot);

      Event[] c = Main.micron.makeWorkstationsCheckQueue(getTime());

      Event[] e = new Event[]{new Stage_Two_End(this.getTime() + timeEnd, lot, workstation)};

      //prints after working
      System.out.println(this);

      //record data to work Station
      workstation.incrementLotsProcessed(1);
      workstation.incrementWorkTime(timeEnd);

      return mergeEvents(c, e);
    }else {

//      System.out.println("Error in finding event in lot");
//      System.out.println("Lot exists: " + workstation.checkForLotAvailibility(lot));
      return new Event[0];

    }
  }


  @Override
  public String toString(){
    return getTime() + ": " + workstation.toString() + " started " + lot.toString() + " [" + workstation.getProcessTime(lot) + "]";
  }
}
