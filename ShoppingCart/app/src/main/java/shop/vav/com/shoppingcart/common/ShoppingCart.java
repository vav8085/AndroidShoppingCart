package shop.vav.com.shoppingcart.common;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.otto.Bus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import shop.vav.com.shoppingcart.core.ShoppingCartApplication;
import shop.vav.com.shoppingcart.core.events.CustomerSelectedEvent;
import shop.vav.com.shoppingcart.core.events.UpdateToolbarEvent;
import shop.vav.com.shoppingcart.model.Customer;
import shop.vav.com.shoppingcart.model.LineItem;
import shop.vav.com.shoppingcart.util.Constants;

/**
 * Created by vaibhav on 8/26/17.
 */

public class ShoppingCart implements ShoppingCartContract {

    private List<LineItem> shoppingCart;
    private Customer selectedCustomer;
    private final SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private final static String LOG_TAG = ShoppingCart.class.getSimpleName();
    private static boolean DEBUG = true;

    @Inject Bus mBus;


    public ShoppingCart(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        ShoppingCartApplication.getInstance()
                .getAppComponent().inject(this);
        initShoppingCart();
    }

    private void initShoppingCart() {
        shoppingCart = new ArrayList<>();
        selectedCustomer = new Customer();
        Gson gson = new Gson();
        if(sharedPreferences.getBoolean(Constants.OPEN_CART_EXISTS,false)){
            String serializedCartItems = sharedPreferences.getString(Constants.SERIALIZED_CART_ITEMS,"");
            if(DEBUG){
                Log.d(LOG_TAG, "Serializing cart items:"+ serializedCartItems);
            }
            String serializedCustomer = sharedPreferences.getString(Constants.SERIALIZED_CUSTOMER,"");
            if(DEBUG){
                Log.d(LOG_TAG, "Serializing customers:"+ serializedCustomer);
            }

            if(serializedCartItems.equals("")){
                shoppingCart = gson.<ArrayList<LineItem>>fromJson(serializedCartItems , new TypeToken<ArrayList<LineItem>>(){}.getType());
            }
            if(serializedCustomer.equals("")){
                selectedCustomer = gson.fromJson(serializedCustomer , Customer.class);
            }
        }
        populateToolbar();
    }

    public void saveCartToPreferences(){
        if(shoppingCart!=null){
            Gson gson = new Gson();
            String serializedItems = gson.toJson(shoppingCart);
            if(DEBUG){
                Log.d(LOG_TAG, "Saving serialized items to shared preferences!");
            }
            String serializedCustomer = gson.toJson(selectedCustomer);
            if(DEBUG){
                Log.d(LOG_TAG, "Saving serialized customer to shared preferences!");
            }

            editor.putString(Constants.SERIALIZED_CART_ITEMS, serializedItems).commit();
            editor.putString(Constants.SERIALIZED_CUSTOMER, serializedCustomer).commit();
            editor.putBoolean(Constants.OPEN_CART_EXISTS,true).commit();
        }
    }

    @Override
    public void addItemToCart(LineItem item) {
        boolean itemInCart = false;
        int itemPosition = 0;
        for(LineItem tempItem: shoppingCart){
            if(tempItem.getId()==item.getId()){
                itemPosition = shoppingCart.indexOf(tempItem);
                itemInCart = true;
                LineItem selectedItem = shoppingCart.get(itemPosition);
                selectedItem.setQuantity(tempItem.getQuantity() + item.getQuantity());
                shoppingCart.set(itemPosition,selectedItem);
                break;
            }
        }
        if(!itemInCart){
            shoppingCart.add(item);
        }
    }

    @Override
    public void removeItemFromCart(LineItem item) {
        shoppingCart.remove(item);
        if(shoppingCart.size()==0){
            mBus.post(new CustomerSelectedEvent(new Customer(),true));
        }
        populateToolbar();

    }

    @Override
    public void clearAllItemsFromCart() {
        shoppingCart.clear();
        selectedCustomer=null;
        editor.putString(Constants.SERIALIZED_CART_ITEMS,"").commit();
        editor.putString(Constants.SERIALIZED_CUSTOMER,"").commit();
        editor.putBoolean(Constants.OPEN_CART_EXISTS,false).commit();
        populateToolbar();
        mBus.post(new CustomerSelectedEvent(new Customer(),true));
    }

    @Override
    public List<LineItem> getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public void setCustomer(Customer customer) {
        selectedCustomer = customer;
        mBus.post(new CustomerSelectedEvent(customer,false));

    }

    @Override
    public void updateItemQty(LineItem item, int qty) {
        boolean itemAlreadyInCart = false;
        int itemPosition = 0;
        for(LineItem tempItem: shoppingCart){
            if(tempItem.getId()==item.getId()){
                itemPosition = shoppingCart.indexOf(tempItem);
                LineItem itemInCart = shoppingCart.get(itemPosition);
                itemInCart.setQuantity(qty);
                shoppingCart.set(itemPosition,itemInCart);
                itemAlreadyInCart = true;
                break;
            }
            if(!itemAlreadyInCart){
                item.setQuantity(qty);
                shoppingCart.add(item);
            }
        }
        populateToolbar();
    }

    @Override
    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    @Override
    public void completeCheckout() {
        shoppingCart.clear();
        mBus.post(new CustomerSelectedEvent(new Customer(),true));
        populateToolbar();
    }
    private void populateToolbar(){
        mBus.post(new UpdateToolbarEvent(shoppingCart));
    }
}
