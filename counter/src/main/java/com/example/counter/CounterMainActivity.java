package com.example.counter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CounterMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_main);
    }

    public void onIncrease(View view) {
        TextView counter = this.findViewById(R.id.txtCounter);
        int c = Integer.parseInt(counter.getText().toString());
        EditText txtStep = this.findViewById(R.id.txtStep);
        int step = Integer.parseInt(txtStep.getText().toString());
        counter.setText("" + (c + step));
    }

    public void onDecrease(View view) {
        TextView counter = this.findViewById(R.id.txtCounter);
        int c = Integer.parseInt(counter.getText().toString());
        EditText txtStep = this.findViewById(R.id.txtStep);
        int step = Integer.parseInt(txtStep.getText().toString());
        counter.setText("" + (c - step));
    }
}