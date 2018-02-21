package system;

import java.text.NumberFormat;

public class Order {
    private String item;
    private int quantity;
    private double price;

    public Order(String item, int quantity, double price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice(){
        return price;
    }

    public double getTotalPrice(){
        return quantity*price;
    }
}
