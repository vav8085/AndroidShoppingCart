package shop.vav.com.shoppingcart.common;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import shop.vav.com.shoppingcart.R;
import shop.vav.com.shoppingcart.ui.checkout.CheckoutFragment;
import shop.vav.com.shoppingcart.ui.customerlist.CustomerListFragment;
import shop.vav.com.shoppingcart.ui.productlist.ProductListAdapter;
import shop.vav.com.shoppingcart.ui.productlist.ProductListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        openFragment(new CheckoutFragment(),"Checkout List");
    }

    private void openFragment(Fragment fragment, String title) {
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.container,fragment)
                .addToBackStack(null)
                .commit();
        getSupportActionBar().setTitle(title);
    }


}
