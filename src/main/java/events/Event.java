package events;

public abstract class Event implements Comparable<Event>{

  private final int time;

  public Event(int time) {
    this.time = time;
  }

  @Override
  public int compareTo(Event e) {
    if (this.time > e.time) {
      return 1;
    } else if (this.time == e.time) {
      return 0;
    } else {
      return -1;
    }
  }

  public int getTime() {
    return time;
  }

  @Override
  public String toString(){
    return String.format("%.3f",this.time);
  }

  public abstract Event[] simulate();
}
