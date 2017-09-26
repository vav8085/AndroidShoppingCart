package shop.vav.com.shoppingcart.ui.customerlist;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shop.vav.com.shoppingcart.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerListFragment extends Fragment {
    private View mRootView;
    private RecyclerView mRecyclerView;

    public CustomerListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


         mRootView = inflater.inflate(R.layout.fragment_customer_list, container, false);

         return mRootView;
    }




}
