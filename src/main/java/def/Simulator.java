package def;

import events.Event;

import java.util.PriorityQueue;

public class Simulator {


  private Micron micron;
  private int lots;

  private final PriorityQueue<Event> events;

  public Simulator(Simulation simulation){
    this.events = new PriorityQueue<Event>();
    this.micron = simulation.getMicron();
    this.lots = simulation.getLots();

    for(Event e : simulation.initialize()){
      this.events.add(e);
    }
  }


  //edit to shut down when production is complete
  public void run(){
    Event e = this.events.poll();
    while (e != null){
      System.out.println(e);
      Event[] newEvents = e.simulate();
      for(Event ev : newEvents){
        this.events.add(ev);
      }
      System.out.println("LOTS PRODUCED: " + Micron.getLots_produced());
      e = this.events.poll();

      if(Micron.getLots_produced() >= lots){
        break;
      }

    }
    System.out.println("DONE!!!!");
  }


}
