package com.example.javacollectionclasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addNewItem(View view){
        EditText txtItemName = this.findViewById(R.id.txtItemName);
        EditText txtCount = this.findViewById(R.id.txtCount);
        EditText txtPrice = this.findViewById(R.id.txtPrice);

        HashMap<String, String> item = new HashMap<>();
        item.put("name", txtItemName.getText().toString());
        item.put("price", txtPrice.getText().toString());
        item.put("count", txtCount.getText().toString());
        this.cart.add(item);

        this.updateTotal();
    }

    public void deleteFirstItem(View view){
        if (this.cart.size() == 0 ){
            return;
        }
        this.cart.remove(0);
        this.updateTotal();
    }

    private void updateTotal() {
        double total = this.calcTotal();

        TextView txtTotal = this.findViewById(R.id.txtTotal);

        txtTotal.setText(String.format("Total:%.2f", total));
    }

    private double calcTotal(){
        double total = 0.0f;
        for(HashMap<String, String> item : this.cart){
            int count = Integer.parseInt(item.get("count"));
            double price = Double.parseDouble(item.get("price"));
            total += count * price;
        }

        return total;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putSerializable("cart", this.cart);

        super.onSaveInstanceState(savedInstanceState);
    }

//onRestoreInstanceState

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        this.cart = (ArrayList<HashMap<String, String>>) savedInstanceState.getSerializable("cart");
        this.updateTotal();
    }
    private ArrayList<HashMap<String, String>> cart = new ArrayList<>();
}