package com.example.randomnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onRandomize(View view){
        int n = new Random().nextInt(10);
        TextView txtNumber = this.findViewById(R.id.txtNumber);
        txtNumber.setText(String.valueOf(n));
    }
}