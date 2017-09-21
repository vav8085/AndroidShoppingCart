package shop.vav.com.shoppingcart.ui.checkout;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindAnim;
import butterknife.BindView;
import butterknife.OnClick;
import shop.vav.com.shoppingcart.R;
import shop.vav.com.shoppingcart.model.LineItem;

/**
 * Created by Vaibhav on 9/21/17.
 */

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.ViewHolder> {
    private List<LineItem> mLineItems;
    private Context mContext;

    public CheckoutAdapter(List<LineItem> lineItems, Context context) {
        mLineItems = lineItems;
        mContext = context;
    }

    @Override
    public CheckoutAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_shopping_cart_items,parent,false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CheckoutAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(mLineItems!=null){
            return mLineItems.size();
        }else return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.product_image) ImageView productImage;
        @BindView(R.id.textview_product_name) TextView productName;
        @BindView(R.id.textview_product_price) TextView productPrice;
        //@BindView(R.id.)
        public ViewHolder(View itemView) {
            super(itemView);


        }

        @Override
        public void onClick(View view) {

        }
    }
}
