package events;

import def.Micron;

public class Lots_Initiated extends Event {

  private Micron micron;

  public Lots_Initiated(int time, Micron micron){
    super(time);
    this.micron = micron;
  }

  @Override
  public Event[] simulate() {
    return micron.makeWorkstationsCheckQueue(0);
  }


  @Override
  public String toString(){
    return getTime() + ": All lots added to Queue";
  }
}
