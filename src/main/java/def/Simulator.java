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

      Event[] newEvents = e.simulate();
      //System.out.println(e);

      for(Event ev : newEvents){
        this.events.add(ev);
      }
      //System.out.println("LOTS PRODUCED: " + Micron.getLots_produced());

      //micron.getFactoryX().printQueue();
      //micron.getFactoryY().printQueue();
      //micron.printCompleted();

      e = this.events.poll();


      if(Micron.getNumb_lots_produced() >= lots){
        break;
      }
      if(total_time >= 10080){
        break;
      }
    }
    System.out.println("DONE!!!!");
    Double efficiency = (double) ( (double) total_time / (double) Micron.getNumb_lots_produced());

    String s = String.format("%.2f", efficiency);
    micron.printCompleted();
    System.out.println("Efficiency: " + s + " minutes/lot");


    micron.outputLotData();
  }


}
