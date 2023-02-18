public class Stage_One_End extends Event {

  private Lot lot;
  private Workstation workstation;

  public Stage_One_End(int time, Lot lot, Workstation workstation){
    super(time);

  }


  @Override
  public Event[] simulate() {
    return new Event[0];
  }
}
