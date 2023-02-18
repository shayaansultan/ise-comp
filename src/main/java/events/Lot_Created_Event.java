package events;

import def.Lot;
import def.Main;

public class Lot_Created_Event extends Event{

  private int lotID;

  public Lot_Created_Event(int time, int ID){
    super(time);
    this.lotID = ID;
  }



  @Override
  public Event[] simulate() {

    Lot lot = new Lot(lotID, 0, "X");
    Main.micron.getFactoryX().addToQueue(lot);

    return Main.micron.makeWorkstationsCheckQueue();
  }
}
