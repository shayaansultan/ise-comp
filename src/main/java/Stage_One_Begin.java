public class Stage_One_Begin extends Event {


  public Stage_One_Begin(int time, Lot lot, Workstation workstation){
    super(time);
  }

  @Override
  public Event[] simulate() {
    return new Event[0];
  }
}
