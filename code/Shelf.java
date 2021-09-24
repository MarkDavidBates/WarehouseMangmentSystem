package sample;

public class Shelf {

    private int shelfNum;
    GenericList pallets;

    public Shelf(int shelfNum) {
        this.shelfNum = shelfNum;
        pallets = new GenericList();
    }

    public void addPallet(Pallet pallet){
        pallets.addElement(pallet);
    }

    public int getShelfNum() {
        return shelfNum;
    }

    public void setShelfNum(int shelfNum) {
        this.shelfNum = shelfNum;
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "shelfNum=" + shelfNum +
                '}';
    }
}
