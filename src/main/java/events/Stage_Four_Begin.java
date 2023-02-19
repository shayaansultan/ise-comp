package events;

import def.Lot;
import def.Main;
import workstations.Workstation;

public class Stage_Four_Begin extends Event {
  private Lot lot;
  private Workstation workstation;

  public Stage_Four_Begin(int time, Lot lot, Workstation workstation){
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

      Event[] e = new Event[]{new Stage_Four_End(this.getTime() + timeEnd, lot, workstation)};

      //prints after working
      System.out.println(this);

      return mergeEvents(c, e);
    }else{

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
