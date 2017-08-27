package shop.vav.com.shoppingcart.module;

/**
 * Created by vaibhav on 8/26/17.
 */

public class lineItem extends Product {
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private double getSumPrice(){
        return getSalePrice() + quantity;
    }
}
