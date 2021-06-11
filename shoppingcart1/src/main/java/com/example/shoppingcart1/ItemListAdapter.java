package com.example.shoppingcart1;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingcart1.items.Merchandize;
import com.example.shoppingcart1.items.ShoppingCart;

import java.util.HashMap;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {
    private final ShoppingCart cart;
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtName;
        private final TextView txtCount;
        private final TextView txtPrice;
        private final ImageView imgItem;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            txtName = view.findViewById(R.id.txtName);
            txtPrice = view.findViewById(R.id.txtPrice);
            txtCount = view.findViewById(R.id.txtCount);
            imgItem = view.findViewById(R.id.imageView);
        }

        public TextView getNameView() {
            return txtName;
        }
        public TextView getCountView() {
            return txtCount;
        }
        public TextView getPriceView() {
            return txtPrice;
        }
        public ImageView getImageItem() { return imgItem; }

        public void setBackground(int color) {
            this.itemView.setBackgroundColor(color);
        }

    }

    public ItemListAdapter(ShoppingCart cart) {
        this.cart = cart;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Merchandize item = this.cart.getItemAt(position);
        viewHolder.getNameView().setText(item.getName());
        viewHolder.getPriceView().setText(String.format("$%.2f",item.getPrice()));
        viewHolder.getCountView().setText(""+ this.cart.getCountAt(position));
        viewHolder.getImageItem().setImageResource(item.getImageId());
        viewHolder.setBackground(position%2==0 ? Color.WHITE:Color.LTGRAY);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return cart.getNumItems();
    }


}
