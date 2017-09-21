package shop.vav.com.shoppingcart.ui.productlist;

import android.content.Context;
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
import butterknife.OnLongClick;
import shop.vav.com.shoppingcart.R;
import shop.vav.com.shoppingcart.core.listeners.OnProductSelectedListener;
import shop.vav.com.shoppingcart.model.Product;
import shop.vav.com.shoppingcart.util.Formatter;

/**
 * Created by z179905 on 9/19/17.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private List<Product> mProducts;
    Context mContext;
    private final OnProductSelectedListener mListener;

    ProductListAdapter(List<Product> products, Context context, OnProductSelectedListener onProductSelectedListener){
        mProducts = products;
        mContext = context;
        this.mListener = onProductSelectedListener;
    }
    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_product_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(mProducts!=null) {
            Product product = mProducts.get(position);
            Picasso.with(mContext)
                    .load(product.getImagePath())
                    .placeholder(R.drawable.default_image)
                    .into(holder.productImage);
            holder.productName.setText(product.getName());
            holder.category.setText(product.getCatagoryName());
            holder.productPrice.setText(Formatter.formatCurrency(product.getSalePrice()));
            String productDescription = product.getDescription();
            String shortDescription = productDescription.substring(0, Math.min(productDescription.length(), 70));
            holder.description.setText(shortDescription);
        }

    }

    @Override
    public int getItemCount() {
        if(mProducts!=null) {
            return mProducts.size();
        }else return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{
        @BindView(R.id.product_image) ImageView productImage;
        @BindView(R.id.textview_product_name) TextView productName;
        @BindView(R.id.textview_product_category) TextView category;
        @BindView(R.id.textview_product_description) TextView description;
        @BindView(R.id.textview_product_price) TextView productPrice;
        @BindView(R.id.image_view_add_to_cart_button) TextView addToCartButton;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.image_view_add_to_cart_button)
        public void onClick(View view) {
            Product selectedProduct = mProducts.get(getLayoutPosition());
            mListener.onSelectProduct(selectedProduct);
            notifyDataSetChanged();
        }

        @Override
        public boolean onLongClick(View view) {
            Product selectedProduct = mProducts.get(getLayoutPosition());
            mListener.onSelectProduct(selectedProduct);
            return true;
        }
    }
}
