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
  public synchronized Event[] simulate() {

    //simulates only if lot is there and the workstation is free (Debugging)
    if(workstation.checkForLotAvailibility(lot) == true && workstation.getAvail()){

      System.out.println(workstation + " is actually working");

      workstation.removeLotFromQueue(lot);
      workstation.setAvail(false);
      int timeEnd = workstation.getProcessTime(lot);


      Event[] c = Main.micron.makeWorkstationsCheckQueue(getTime());
      Event[] e = new Event[] {new Stage_One_End(this.getTime() + timeEnd, lot, workstation)};

      return mergeEvents(c, e);
    }else{

      System.out.println("Error in finding event in lot");
      System.out.println("Lot exists: " + workstation.checkForLotAvailibility(lot));
      return new Event[0];

    }
  }

  @Override
  public String toString(){
    return getTime() + ": " + workstation.toString() + " started " + lot.toString();
  }
}
