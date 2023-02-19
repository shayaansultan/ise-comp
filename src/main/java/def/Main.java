package def;

import factory.Factory_X;
import factory.Factory_Y;

public class Main {

  public static Micron micron;

  public static void main(String[] args) {

    Factory_X x = new Factory_X();
    Factory_Y y = new Factory_Y();

    Truck truck = new Truck();

    micron = new Micron(truck, x, y);

    Simulation s = new Simulation(1000, micron);


    new Simulator(s).run();
  }

}
