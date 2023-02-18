import events.Event;

import java.util.PriorityQueue;

public class Simulator {


  private final PriorityQueue<Event> events;

  public Simulator(Simulation simulation){
    this.events = new PriorityQueue<Event>();

    for(Event e : simulation.initialize()){
      this.events.add(e);
    }
  }

  public void run(){
    Event e = this.events.poll();
    while (e != null){
      System.out.println(e);
      Event[] newEvents = e.simulate();
      for(Event ev : newEvents){
        this.events.add(ev);
      }
      e = this.events.poll();
    }
  }


}
