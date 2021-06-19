package com.example.multiscreenapp;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.multiscreenapp.items.Merchandise;
import com.example.multiscreenapp.items.ShoppingCart;

import java.io.Serializable;

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
            imgItem = view.findViewById(R.id.imgItem);
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

        Merchandise item = this.cart.getItemAt(position);
        int count = this.cart.getCountAt(position);
        viewHolder.getNameView().setText(item.getName());
        viewHolder.getPriceView().setText(String.format("$%.2f",item.getPrice()));
        viewHolder.getCountView().setText(""+ count);
        viewHolder.getImageItem().setImageResource(item.getImageId());
        viewHolder.setBackground(position%2==0 ? Color.WHITE:Color.LTGRAY);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(v.getContext(), position + "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), ItemDetailsActivity.class);
                intent.putExtra("item", (Serializable) item);
                intent.putExtra("count",count);
                view.getContext().startActivity(intent);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return cart.getNumItems();
    }


}
