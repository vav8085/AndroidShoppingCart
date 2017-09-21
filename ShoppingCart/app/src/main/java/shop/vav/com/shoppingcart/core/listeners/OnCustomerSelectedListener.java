package shop.vav.com.shoppingcart.core.listeners;

import shop.vav.com.shoppingcart.model.Customer;

/**
 * Created by z179905 on 9/20/17.
 */

public interface OnCustomerSelectedListener {
    void onSelectedCustomer(Customer customer);
    void onLongClickCustomer(Customer customer);
}
