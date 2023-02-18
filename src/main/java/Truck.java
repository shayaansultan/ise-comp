import java.io.ObjectInputFilter.Status;

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

}
