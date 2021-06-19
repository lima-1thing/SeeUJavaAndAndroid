package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.multiscreenapp.items.Merchandise;

public class ItemDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        Bundle extra = getIntent().getExtras();
        Merchandise item = (Merchandise)(extra.getSerializable("item"));
        int count = extra.getInt("count");
        TextView txtName = this.findViewById(R.id.txtName);
        txtName.setText(item.getName());

        TextView txtPrice = this.findViewById(R.id.txtPrice);
        txtPrice.setText(String.format("$%.2f", item.getPrice()));

        TextView txtCount = this.findViewById(R.id.txtCount);
        txtCount.setText(String.format("%d", count));

        TextView txtTotal = this.findViewById(R.id.txtTotal);
        txtTotal.setText(String.format("%.2f", count*item.getPrice()));

        ImageView image = this.findViewById(R.id.imgItem);
        image.setImageResource(item.getImageId());

    }
}