package shop.vav.com.shoppingcart.core.events;

import java.util.List;

import shop.vav.com.shoppingcart.model.LineItem;

/**
 * Created by Vaibhav on 12/7/17.
 */

public class UpdateToolbarEvent {
    private final List<LineItem> lineItems;

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public UpdateToolbarEvent(List<LineItem> lineItem) {
        this.lineItems = lineItem;

    }
}
