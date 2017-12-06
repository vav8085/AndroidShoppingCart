package shop.vav.com.shoppingcart.common;

import java.util.List;

import shop.vav.com.shoppingcart.model.Customer;
import shop.vav.com.shoppingcart.model.LineItem;

/**
 * Created by Vaibhav on 12/6/17.
 */

public interface ShoppingCartContract {
    void addItemToCart(LineItem item);
    void removeItemFromCart(LineItem item);
    void clearAllItemsFromCart();
    List<LineItem> getShoppingCart();
    void setCustomer(Customer customer);
    void updateItemQty(LineItem item, int qty);
    Customer getSelectedCustomer();
    void completeCheckout();
}
