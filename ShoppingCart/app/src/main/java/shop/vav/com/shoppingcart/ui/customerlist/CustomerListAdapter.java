package shop.vav.com.shoppingcart.ui.customerlist;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import shop.vav.com.shoppingcart.R;
import shop.vav.com.shoppingcart.core.listeners.OnCustomerSelectedListener;
import shop.vav.com.shoppingcart.model.Customer;

/**
 * Created by Vaibhav on 9/19/17.
 */

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.ViewHolder> {
    List<Customer> mCustomers;
    private Context mContext;
    private OnCustomerSelectedListener mListener;
    private boolean shouldHighlightSelectedCustomer = false;
    private int selectedposition = 0;

    CustomerListAdapter(List<Customer> mCustomers, Context context, OnCustomerSelectedListener onCustomerSelectedListener){
        this.mCustomers = mCustomers;
        mContext = context;
        mListener = onCustomerSelectedListener;
    }

    @Override
    public CustomerListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_customer_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomerListAdapter.ViewHolder holder, int position) {
        final Customer selectedCustomer = mCustomers.get(position);
        holder.customerName.setText(selectedCustomer.getCustomerName());
        holder.customerEmail.setText(selectedCustomer.getEmailAddress());
        Picasso.with(mContext)
                .load(selectedCustomer.getProfileImagePath())
                .placeholder(R.drawable.profile_icon)
                .fit()
                .into(holder.customerHeadShot);
        if(shouldHighlightSelectedCustomer){
            if(selectedposition==position){
                holder.itemView.setBackgroundColor(ContextCompat.getColor(mContext,R.color.primary_light));
            }else{
                holder.itemView.setBackgroundColor(Color.TRANSPARENT);
            }
        }else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount() {
        if(mCustomers!=null){
            return mCustomers.size();
        }else return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener{
        @BindView(R.id.image_view_customer_head_shot) ImageView customerHeadShot;
        @BindView(R.id.text_view_customer_email) TextView customerEmail;
        @BindView(R.id.text_view_customer_name) TextView customerName;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View view) {
            Customer selectedCustomer = mCustomers.get(getLayoutPosition());
            mListener.onLongClickCustomer(selectedCustomer);
            return true;
        }

        @Override
        public void onClick(View view) {
            shouldHighlightSelectedCustomer = true;
            selectedposition = getLayoutPosition();
            Customer selectedCustomer = mCustomers.get(selectedposition);
            mListener.onSelectedCustomer(selectedCustomer);

        }
    }
}
