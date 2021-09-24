package sample;

public class Pallet {

    private String goods;
    private int quantity;
    private double minTemp;
    private double maxTemp;

    public Pallet(String goods, int quantity, double minTemp, double maxTemp) {
        this.goods = goods;
        this.quantity = quantity;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    @Override
    public String toString() {
        return "Pallet{" +
                "goods='" + goods + '\'' +
                ", quantity=" + quantity +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                '}';
    }
}
