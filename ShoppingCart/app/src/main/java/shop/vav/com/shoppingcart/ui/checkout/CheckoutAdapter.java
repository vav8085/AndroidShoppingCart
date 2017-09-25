package shop.vav.com.shoppingcart.ui.checkout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Formatter;
import java.util.List;
import java.util.TooManyListenersException;

import butterknife.BindAnim;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import shop.vav.com.shoppingcart.R;
import shop.vav.com.shoppingcart.core.listeners.CartActionsListener;
import shop.vav.com.shoppingcart.model.LineItem;

/**
 * Created by Vaibhav on 9/21/17.
 */

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.ViewHolder> {
    private List<LineItem> mLineItems;
    private Activity mContext;
    private CartActionsListener mListener ;

    public CheckoutAdapter(List<LineItem> lineItems, Context context, CartActionsListener listener) {
        mLineItems = lineItems;
        mContext = (Activity) context;
        mListener = listener;
    }

    @Override
    public CheckoutAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_shopping_cart_items,parent,false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CheckoutAdapter.ViewHolder holder, int position) {
        LineItem item = mLineItems.get(position);
        Picasso.with(mContext).load(item.getImagePath()).fit().placeholder(R.drawable.default_image).into(holder.productImage);
        holder.price.setText(shop.vav.com.shoppingcart.util.Formatter.formatCurrency(item.getSalePrice()));
        holder.qtyEditText.setText(String.valueOf(item.getQuantity()));

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
        @BindView(R.id.textview_product_price) TextView price;
        @BindView(R.id.edit_text_qty) EditText qtyEditText;
        @BindView(R.id.button_delete) Button deleteButton;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView );
            deleteButton.setOnClickListener(this);

        }
        @OnClick(R.id.edit_text_qty)
        public void onQtyClick(View view){
            //handle the change of line item quantity
            LineItem item = mLineItems.get(getLayoutPosition());
            updateQtyDialog(item);

        }
        @Override
        public void onClick(View view) {
            LineItem item = mLineItems.get(getLayoutPosition());
            mListener.onItemDeleted(item);
        }
    }

    private void updateQtyDialog(final LineItem item) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = mContext.getLayoutInflater();
        View rootView = inflater.inflate(R.layout.dialog_enter_item_qty,null);
        dialog.setView(rootView);
        View titleView = inflater.inflate(R.layout.dialog_title,null);
        TextView titleText = titleView.findViewById(R.id.text_view_dialog_title);

        titleText.setText(item.getName());
        dialog.setCustomTitle(titleView);

        final EditText qtyEditText = rootView.findViewById(R.id.edit_text_item_qty);
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(qtyEditText.getText().toString().isEmpty()){
                    int qtyEntered = Integer.parseInt(qtyEditText.getText().toString());
                    mListener.onItemQtyChanged(item,qtyEntered);
                }else{
                    Toast.makeText(mContext,"Invalid Quantity", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

    }
}
