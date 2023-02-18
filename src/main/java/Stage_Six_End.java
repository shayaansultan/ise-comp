import events.Event;

public class Stage_Six_End extends Event {
  private Lot lot;
  private Workstation workstation;

  public Stage_Six_End(int time, Lot lot, Workstation workstation){
    super(time);

    this.lot = lot;
    this.workstation = workstation;
  }


  @Override
  public Event[] simulate() {

    Micron.incrementLotsProduced();


    return new Event[0];
  }
}
