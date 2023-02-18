package def;

import java.util.Arrays;

public class Truck {
    private Lot[] lots = new Lot[5];
    private String status = "X";

    public Truck() {
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
        
    }

    public void loadLots(){

    }

    @Override
    public String toString() {
        return  Arrays.toString(lots);
    }
}
