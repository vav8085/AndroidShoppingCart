package shop.vav.com.shoppingcart.core.listeners;

import shop.vav.com.shoppingcart.model.Product;

/**
 * Created by z179905 on 9/18/17.
 */

public interface OnProductSelectedListener {
    void onSelectProduct(Product selectedProduct);
    void onLongClickOfProduct(Product clickedProduct);
}
