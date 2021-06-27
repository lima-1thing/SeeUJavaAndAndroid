package com.example.multiscreen;

import static android.graphics.Color.*;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;

public class BorderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_border);

        LinearLayout layout = findViewById(R.id.layoutGrid);

        createGrid(layout);
    }

    private void createGrid(LinearLayout layout) {
        int size = 6;
        for(int i=0; i<size; i++){
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setBackgroundColor(BLACK);
            for(int j=0; j< size; j++){
                EditText txt = new EditText(this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1.0f
                );
                params.setMargins(4,4,4,4);
                txt.setLayoutParams(params);
                txt.setBackgroundColor(WHITE);
                txt.setText(String.format("%02d", i*size + j));
//                txt.setWidth(100);
//                txt.setHeight(100);
                txt.setGravity(Gravity.CENTER);
                row.addView(txt);
            }
            layout.addView(row);
        }
    }
}