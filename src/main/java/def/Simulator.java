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


  //WE PRINT EVENT FIRST THEN WE SIMULATE

  //edit to shut down when production is complete
  public void run(){
    int total_time = 0;
    Event e = this.events.poll();
    while (e != null){
      total_time = e.getTime();
      System.out.println(e);
      Event[] newEvents = e.simulate();
      for(Event ev : newEvents){
        this.events.add(ev);
      }
      //System.out.println("LOTS PRODUCED: " + Micron.getLots_produced());
      micron.getFactoryX().printQueue();
      micron.getFactoryY().printQueue();
      e = this.events.poll();


      if(Micron.getLots_produced() >= lots){
        break;
      }
      if(total_time >= 10080){
        break;
      }
    }
    System.out.println("DONE!!!!");
    Double efficiency = (double) ( (double) total_time / (double) Micron.getLots_produced());

    String s = String.format("%.2f", efficiency);
    System.out.println("Efficiency: " + s + " minutes/lot");
  }


}
