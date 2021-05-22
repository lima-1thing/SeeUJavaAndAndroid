package com.example.counter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CounterMainActivity extends AppCompatActivity {

    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_main);
        TextView txtCounter = this.findViewById(R.id.txtCounter);
        txtCounter.setText("" + this.counter);

    }

    public void onIncrease(View view) {
        EditText txtStep = this.findViewById(R.id.txtStep);
        int step = Integer.parseInt(txtStep.getText().toString());
        this.counter += step;

        TextView txtCounter = this.findViewById(R.id.txtCounter);
        txtCounter.setText("" + this.counter);
    }

    public void onDecrease(View view) {
        EditText txtStep = this.findViewById(R.id.txtStep);
        int step = Integer.parseInt(txtStep.getText().toString());
        this.counter -= step;

        TextView txtCounter = this.findViewById(R.id.txtCounter);
        txtCounter.setText("" + this.counter);
    }
}