package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    public void onClick0(View view) {
        TextView txtView = this.findViewById(R.id.txtCounter);
        txtView.setText("0");
    }

    public void onClick1(View view) {
        TextView txtView = this.findViewById(R.id.txtCounter);
        txtView.setText("1");
    }
}