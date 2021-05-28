package com.example.diceanimated;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    static private final int[] dice_ids = {R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
            R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.sw = findViewById(R.id.imageSwitcher);
        this.sw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new
                        ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.WRAP_CONTENT,
                        ActionBar.LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });

        Animation in =  AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
        Animation out =  AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomout);
        this.sw.setInAnimation(in);
        this.sw.setOutAnimation(out);
    }

    public void roll(View view){
        int dice = new Random().nextInt(dice_ids.length);
        this.sw.setImageResource(dice_ids[dice]);
    }

    private ImageSwitcher sw;
}