package events;

import def.Lot;
import def.Main;

public class Lot_Created_Event extends Event{

  private int lotID;
  private Lot lot;

  public Lot_Created_Event(int time, int ID){
    super(time);
    this.lotID = ID;
    Lot lot = new Lot(lotID, 0, "X");
    this.lot = lot;
    Main.micron.getFactoryX().addToQueue(lot);

  }




  @Override
  public Event[] simulate() {
    return Main.micron.makeWorkstationsCheckQueue(getTime());
  }

  @Override
  public String toString() {
    return getTime() + ": Created " + lot.toString();
  }
}
