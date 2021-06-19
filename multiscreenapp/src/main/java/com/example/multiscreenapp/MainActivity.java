package com.example.multiscreenapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multiscreenapp.items.Apple;
import com.example.multiscreenapp.items.Avacado;
import com.example.multiscreenapp.items.Cheese;
import com.example.multiscreenapp.items.Merchandise;
import com.example.multiscreenapp.items.Milk;
import com.example.multiscreenapp.items.ShoppingCart;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView itemListView = this.findViewById(R.id.itemList);
        itemListView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        this.adapter = new ItemListAdapter(ShoppingCart.getShoppingCart());
        itemListView.setAdapter(adapter);


//        String names[] = {"Apple", "Milk", "Cheese", "Avacado"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item,
//                R.id.txtItem, names);
//        this.spin = (Spinner) findViewById(R.id.spinItems);
//        spin.setAdapter(adapter);

        Merchandise[] items = {new Apple(), new Cheese(), new Avacado(), new Milk(),
                new Merchandise("Beef Jerkey", R.drawable.beefjerkey, 19.95),
                new Merchandise("Egg", R.drawable.egg, 4.55),
                new Merchandise("Bread", R.drawable.bread, 3.45),
                new Merchandise("Butter", R.drawable.butter, 9.95)};
        this.spin = (Spinner) findViewById(R.id.spinItems);
        ItemAdaptor adapter = new ItemAdaptor(this, R.layout.dropdown_item,
                R.id.txtItem, items);
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        spin.setAdapter(adapter);


    }

    public void addNewItem(View view) {
        view.clearFocus();

        Merchandise item = (Merchandise) this.spin.getSelectedItem();
        EditText txtCount = this.findViewById(R.id.txtCount);

        ShoppingCart.getShoppingCart().addItem(item, Integer.parseInt(txtCount.getText().toString()));

        this.updateTotal();
        this.adapter.notifyDataSetChanged();
    }

    public void deleteFirstItem(View view) {
        if (ShoppingCart.getShoppingCart().getNumItems() == 0) {
            return;
        }
        ShoppingCart.getShoppingCart().removeAt(0);
        this.updateTotal();
        this.adapter.notifyDataSetChanged();
    }

    private void updateTotal() {
        double total = this.calcTotal();

        TextView txtTotal = this.findViewById(R.id.txtTotal);

        txtTotal.setText(String.format("Total:%.2f", total));

        System.out.println(String.format("Total:%.2f", total));
    }

    private double calcTotal() {
        double total = 0.0f;
        for (int i = 0; i < ShoppingCart.getShoppingCart().getNumItems(); i++) {
            int count = ShoppingCart.getShoppingCart().getCountAt(i);
            double price = ShoppingCart.getShoppingCart().getItemAt(i).getPrice();
            total += count * price;
        }

        return total;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        this.updateTotal();

        RecyclerView itemListView = this.findViewById(R.id.itemList);
        itemListView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        this.adapter = new ItemListAdapter(ShoppingCart.getShoppingCart());
        itemListView.setAdapter(adapter);
    }

    private ItemListAdapter adapter;
    private Spinner spin;
}