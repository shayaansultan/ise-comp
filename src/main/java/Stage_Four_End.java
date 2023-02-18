import events.Event;

public class Stage_Four_End extends Event {
  private Lot lot;
  private Workstation workstation;

  public Stage_Four_End(int time, Lot lot, Workstation workstation){
    super(time);

    this.lot = lot;
    this.workstation = workstation;
  }


  @Override
  public Event[] simulate() {
    return new Event[0];
  }
}
