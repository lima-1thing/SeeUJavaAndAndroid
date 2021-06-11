package com.example.shoppingcart1;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.shoppingcart1.items.Merchandize;

public class ItemAdaptor extends ArrayAdapter<Merchandize> {
    public ItemAdaptor(@NonNull Context context, int resource, int textViewResourceId, @NonNull Merchandize[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    private View populateView(View view, int position){
        Merchandize item = this.getItem(position);
        ImageView img = view.findViewById(R.id.imgItem);
        img.setImageResource(item.getImageId());

        TextView txtName = view.findViewById(R.id.txtItem);
        txtName.setText(item.getName());

        TextView txtPrice = view.findViewById(R.id.txtPrice);
        txtPrice.setText(String.format("$%.2f", item.getPrice()));
        return view;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view =  super.getView(position, convertView, parent);
        return populateView(view, position);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view =  super.getDropDownView(position, convertView, parent);
        populateView(view, position);
        view.setBackgroundColor(position%2==0? Color.WHITE : Color.LTGRAY);
        return view;
    }
}
