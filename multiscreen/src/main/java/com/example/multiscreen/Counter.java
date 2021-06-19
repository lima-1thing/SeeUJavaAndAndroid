package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Counter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        this.viewCount = this.findViewById(R.id.txtCounter);
        this.txtStep = this.findViewById(R.id.txtStep);

        if(null != savedInstanceState) {
            this.count = savedInstanceState.getInt("count", 0);
            viewCount.setText(String.valueOf(this.count));
        }
    }

    private int getStep(){
        try {
            return Integer.valueOf(this.txtStep.getText().toString());
        }
        catch (Exception e){
            return 0;
        }
    }
    public void increase(View view){
        this.count += this.getStep();
        viewCount.setText(String.valueOf(this.count));
    }

    public void decrease(View view){
        this.count -= this.getStep();
        viewCount.setText(String.valueOf(this.count));
    }

    @Override
    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("count", this.count);
    }
    private int count=0;
    private TextView viewCount;
    private EditText txtStep;

}