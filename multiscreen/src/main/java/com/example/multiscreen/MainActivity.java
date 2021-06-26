package com.example.multiscreen;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static public final int ACT_COUNTER = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void counter(View view){
        Intent intent = new Intent(this, CounterWithResultActivity.class);
        startActivityForResult(intent, ACT_COUNTER);
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == ACT_COUNTER) {
            if (resultCode == RESULT_OK) {
                // A contact was picked.  Here we will just display it
                // to the user.
                Toast toast = Toast.makeText(this, "Current counter is:" + data.getIntExtra("counter", 0),
                        Toast.LENGTH_LONG);
                toast.show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void alertDialogDemo(View view){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("You just hit an AlertDialog")
                .setTitle("Oops, Something is Wrong!")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Context context = getApplicationContext();
                        CharSequence text = "Glad you reach this far! Peace.";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                });
        alertDialogBuilder.create().show();
    }
}