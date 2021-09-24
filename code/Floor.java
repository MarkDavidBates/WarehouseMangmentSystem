package sample;

public class Floor {

    private int floorNum;
    private String securityLvl;
    private double temperature;
    GenericList aisles;

    public Floor(int floorNum, String securityLvl, double temperature) {
        this.floorNum = floorNum;
        this.securityLvl = securityLvl;
        this.temperature = temperature;
        aisles = new GenericList<>();
    }

    public void addAisle(Aisle aisle){
        aisles.addElement(aisle);
    }

    //getters+setters//

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public String getSecurityLvl() {
        return securityLvl;
    }

    public void setSecurityLvl(String securityLvl) {
        this.securityLvl = securityLvl;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "Floor Number=" + floorNum +
                ", Security Level='" + securityLvl + '\'' +
                ", Temperature=" + temperature +
                '}';
    }
}
