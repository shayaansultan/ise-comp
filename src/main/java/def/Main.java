package def;

import factory.Factory_X;
import factory.Factory_Y;
import workstations.*;
import workstations.Workstation;

public class Main {

  public static Micron micron;

  public static void main(String[] args) {

    Factory_X x = new Factory_X();
    Factory_Y y = new Factory_Y();

    Workstation[] workstations = new Workstation[] {new A(micron),
                                                    new B(),
                                                    new C(),
                                                    new D(),
                                                    new E(),
                                                    new F()};

    Truck truck = new Truck();

    micron = new Micron(workstations, truck, x, y);

    Simulation s = new Simulation(10);


    new Simulator(s).run();
  }

}
