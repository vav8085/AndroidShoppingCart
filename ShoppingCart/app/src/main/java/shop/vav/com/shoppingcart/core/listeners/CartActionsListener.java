package shop.vav.com.shoppingcart.core.listeners;

import shop.vav.com.shoppingcart.model.LineItem;

/**
 * Created by z179905 on 9/25/17.
 */

public interface CartActionsListener {
    void onItemDeleted(LineItem item);
    void onItemQtyChanged(LineItem item, int qtyEntered);
}
