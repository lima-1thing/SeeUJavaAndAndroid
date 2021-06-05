package com.example.leapyear;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCheck(View view){
        EditText txtYear = findViewById(R.id.txtYear);
        int year = Integer.parseInt(txtYear.getText().toString());
        TextView msg = findViewById(R.id.txtMessage);
        if (year%4 ==0 && (year%100 != 0 || year%400 == 0)){
            msg.setText("This is leap year!");
        } else {
            msg.setText("This is NOT leap year!");
        }
    }
}