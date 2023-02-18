package def;

public class Lot {
    private int lotId ;
    private int stage ;
    private String location ;

    public Lot(int id, int stage, String location) {
        this.lotId = id ;
        this.stage = stage ;
        this.location = location;
    }

    public void setStage(int stage){
        this.stage = stage;
    }

    public int getId() {
        return this.lotId ;
    }

    public int getStage() {
        return this.stage ;
    }

    public String getLocation() {
        return this.location;
    }

    @Override
    public String toString(){
        return "L" + this.lotId + " (stage: " + stage + ")";
    }
}

