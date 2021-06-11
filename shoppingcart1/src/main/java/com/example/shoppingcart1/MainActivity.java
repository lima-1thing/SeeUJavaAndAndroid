package com.example.shoppingcart1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingcart1.items.Apple;
import com.example.shoppingcart1.items.Avacado;
import com.example.shoppingcart1.items.Cheese;
import com.example.shoppingcart1.items.Merchandize;
import com.example.shoppingcart1.items.Milk;
import com.example.shoppingcart1.items.ShoppingCart;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView itemListView = this.findViewById(R.id.itemList);
        itemListView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        this.adapter = new ItemListAdapter(this.cart);
        itemListView.setAdapter(adapter);

        Merchandize[] items = {new Apple(), new Cheese(), new Avacado(), new Milk(),
                new Merchandize("Beef Jerkey", R.drawable.beefjerkey, 19.95),
                new Merchandize("Egg", R.drawable.egg, 4.55),
                new Merchandize("Bread", R.drawable.bread, 3.45),
                new Merchandize("Butter", R.drawable.butter, 9.95)};
        this.spin = (Spinner) findViewById(R.id.spinItems);
        ItemAdaptor adapter = new ItemAdaptor(this, R.layout.dropdown_item,
                R.id.txtItem, items);
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        spin.setAdapter(adapter);
    }

    public void addNewItem(View view) {
        view.clearFocus();

        Merchandize item = (Merchandize) this.spin.getSelectedItem();
        EditText txtCount = this.findViewById(R.id.txtCount);

        this.cart.addItem(item, Integer.parseInt(txtCount.getText().toString()));

        this.updateTotal();
        this.adapter.notifyDataSetChanged();
    }

    public void deleteFirstItem(View view) {
        if (this.cart.getNumItems() == 0) {
            return;
        }
        this.cart.removeAt(0);
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
        for (int i = 0; i < this.cart.getNumItems(); i++) {
            int count = this.cart.getCountAt(i);
            double price = this.cart.getItemAt(i).getPrice();
            total += count * price;
        }

        return total;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putSerializable("cart", this.cart);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        this.cart = (ShoppingCart) savedInstanceState.getSerializable("cart");
        this.updateTotal();

        RecyclerView itemListView = this.findViewById(R.id.itemList);
        itemListView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        this.adapter = new ItemListAdapter(this.cart);
        itemListView.setAdapter(adapter);
    }

    private ShoppingCart cart = new ShoppingCart();
    private ItemListAdapter adapter;
    private Spinner spin;
}