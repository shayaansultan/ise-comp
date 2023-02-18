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

    public int getId() {
        return this.lotId ;
    }

    public int getStage() {
        return this.stage ;
    }

    public String getLocation() {
        return this.location;
    }
}

