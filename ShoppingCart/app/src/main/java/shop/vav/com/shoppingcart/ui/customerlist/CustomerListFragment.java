package shop.vav.com.shoppingcart.ui.customerlist;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import shop.vav.com.shoppingcart.R;
import shop.vav.com.shoppingcart.core.listeners.OnCustomerSelectedListener;
import shop.vav.com.shoppingcart.model.Customer;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerListFragment extends Fragment implements OnCustomerSelectedListener{
    private View mRootView;
    private CustomerListAdapter mAdapter;
    @BindView(R.id.custome_list_recyclerview) RecyclerView mRecyclerView;
    @BindView(R.id.empty_text) TextView mExptyTextView;
    @BindView(R.id.fab) FloatingActionButton mFab;

    public CustomerListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        mRootView = inflater.inflate(R.layout.fragment_customer_list, container, false);
        ButterKnife.bind(this,mRootView);

        //Adapter
        List<Customer> tempCustomer = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mAdapter = new CustomerListAdapter(tempCustomer,getActivity(),this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        if(tempCustomer.size()<1){
            showEmptyTextMessage();
        }else{
            hideEmptyTextMessage();
        }

        return mRootView;
    }

    private void hideEmptyTextMessage() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mExptyTextView.setVisibility(View.GONE);
    }

    private void showEmptyTextMessage() {
        mRecyclerView.setVisibility(View.GONE);
        mExptyTextView.setVisibility(View.VISIBLE);
    }


    @Override
    public void onSelectedCustomer(Customer customer) {

    }

    @Override
    public void onLongClickCustomer(Customer customer) {

    }
}
