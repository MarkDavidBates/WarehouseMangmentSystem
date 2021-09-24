package sample;

public class Aisle {

    private String aisleID;
    private int aisleX;
    private int aisleY;
    GenericList shelves;

    public Aisle(String aisleID, int x, int aisleX, int aisleY) {
        this.aisleID = aisleID;
        this.aisleX = aisleX;
        this.aisleY = aisleY;
        shelves = new GenericList();
    }

    public void addShelf(Shelf shelf){
        shelves.addElement(shelf);
    }

    //getters+setters//

    public String getAisleID() {
        return aisleID;
    }

    public void setAisleID(String aisleID) {
        this.aisleID = aisleID;
    }

    public int getAisleX() {
        return aisleX;
    }

    public void setAisleX(int aisleX) {
        this.aisleX = aisleX;
    }

    public int getAisleY() {
        return aisleY;
    }

    public void setAisleY(int aisleY) {
        this.aisleY = aisleY;
    }

    @Override
    public String toString() {
        return "Aisle{" +
                "aisleID='" + aisleID + '\'' +
                ", aisleX=" + aisleX +
                ", aisleY=" + aisleY +
                '}';
    }
}
