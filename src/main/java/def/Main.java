package def;

import factory.Factory_X;
import factory.Factory_Y;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {

  public static Micron micron;

  public static void main(String[] args) throws FileNotFoundException {

    PrintStream printStream = new PrintStream(new File("out.txt"));

    //System.setOut(printStream);


    Factory_X x = new Factory_X();
    Factory_Y y = new Factory_Y();

    Truck truck = new Truck();

    micron = new Micron(truck, x, y);

    Simulation s = new Simulation(1000, micron);


    new Simulator(s).run();
  }

}
