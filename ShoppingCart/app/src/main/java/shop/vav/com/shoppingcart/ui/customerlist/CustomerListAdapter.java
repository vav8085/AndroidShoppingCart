package shop.vav.com.shoppingcart.ui.customerlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import shop.vav.com.shoppingcart.R;
import shop.vav.com.shoppingcart.model.Customer;

/**
 * Created by Vaibhav on 9/19/17.
 */

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.ViewHolder> {
    List<Customer> mCustomers;

    CustomerListAdapter(List<Customer> mCustomers){
        this.mCustomers = mCustomers;
    }

    @Override
    public CustomerListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CustomerListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(mCustomers!=null){
            return mCustomers.size();
        }else return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener{
        @BindView(R.id.image_view_customer_head_shot) ImageView customerHeadShot;
        @BindView(R.id.text_view_customer_email) ImageView customerEmail;
        @BindView(R.id.text_view_customer_name) ImageView customerName;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }

        @Override
        public void onClick(View view) {

        }
    }
}
