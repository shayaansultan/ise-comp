package def;

public class Lot {
    private int lotId ;
    private int stage ;
    private String location ;


    private int started_production;
    private int ended_production;



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


    public int getStarted_production() {
        return started_production;
    }

    public void setStarted_production(int started_production) {
        this.started_production = started_production;
    }

    public int getEnded_production() {
        return ended_production;
    }

    public void setEnded_production(int ended_production) {
        this.ended_production = ended_production;
    }
}

