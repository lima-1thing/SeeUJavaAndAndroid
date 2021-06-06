package com.example.shoppingcart;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtName;
        private final TextView txtCount;
        private final TextView txtPrice;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            txtName = view.findViewById(R.id.txtName);
            txtPrice = view.findViewById(R.id.txtPrice);
            txtCount = view.findViewById(R.id.txtCount);
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

        public void setBackgroun(int color) {
            this.itemView.setBackgroundColor(color);
        }

    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public ItemListAdapter(ArrayList<HashMap<String, String>> cart) {
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

        HashMap<String,String> item = this.cart.get(position);
        viewHolder.getNameView().setText(item.get("name"));
        viewHolder.getPriceView().setText(String.format("$%.2f",Double.parseDouble(item.get("price"))));
        viewHolder.getCountView().setText(item.get("count"));
        viewHolder.setBackgroun(position%2==0? Color.WHITE:Color.LTGRAY);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return cart.size();
    }

    private final ArrayList<HashMap<String, String>> cart;
}
