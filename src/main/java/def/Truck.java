package def;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public class Truck {
    private Lot[] lots;
    private String status = "X";

    public Truck() {
        lots = new Lot[5];
        clearLots();
    }

    public void setStatus(String status) {
        this.status = status ;
    }


    public String getStatus() {
        return this.status ;
    }


    public Lot[] getLots() {
        return this.lots ;
    }


    public void clearLots() {
        for(int i = 0; i < lots.length; i++){
            lots[i] = null;
        }
    }


    //Write Algorithmn here;
    //Event simulation assumption: truck always keeps travelling. Change Simulation for changing behaviour.
    public void loadLots(){

        int[] priorityOrder = new int[5];
        ArrayList<Lot> tempQueue = new ArrayList<>();
        ArrayList<Lot> queue;

        if(this.status.equals("X")){

            priorityOrder = new int[] {3};

            queue = Main.micron.getFactoryX().getQueue();
        }else{

            priorityOrder = new int[] {1};

            queue = Main.micron.getFactoryY().getQueue();
        }


        //loads up truck according to defined priority
        for(int i = 0; i < priorityOrder.length; i ++){

            Lot l = checkQueueForLot(queue, priorityOrder[i]);
            while(l != null){
                queue.remove(l); //remove from Queue
                tempQueue.add(l); //add to Temporary Queue

                l = checkQueueForLot(queue, priorityOrder[i]);

                //quit search if size is greater than 5
                if(tempQueue.size() >= 5){
                    break;
                }
            }

            //quit search if size is greater than 5
            if(tempQueue.size() >= 5){
                break;
            }
        }

        this.lots = adjustLots(tempQueue); //set lots as tempQueue;
    }

    //returns an array of size 5 (null if empty)
    private Lot[] adjustLots(ArrayList<Lot> lots){

        //make array and have all the slots as null
        Lot[] res = new Lot[5];
        for(int i = 0; i < res.length; i++){
            res[i] = null;
        }

        //fill it with non-null values
        int s = lots.size();
        for(int i = 0; i < s; i++){
            res[i] = lots.get(i);
        }

        //return the result
        return res;
    }


    protected @Nullable
    Lot checkQueueForLot(ArrayList<Lot> queue, int stage){
        for(Lot elem : queue){
            if(elem.getStage() == stage){
                return elem;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(lots);
    }
}
