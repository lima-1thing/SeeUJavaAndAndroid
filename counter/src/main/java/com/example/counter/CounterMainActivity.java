package com.example.counter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CounterMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_main);
    }

    public void onIncrease(View view) {
        EditText counter = this.findViewById(R.id.txtCounter);
        int c = Integer.parseInt(counter.getText().toString());
        counter.setText("" + (c + 1));
    }

    public void onDecrease(View view) {
        EditText counter = this.findViewById(R.id.txtCounter);
        int c = Integer.parseInt(counter.getText().toString());
        counter.setText("" + (c - 1));
    }
}