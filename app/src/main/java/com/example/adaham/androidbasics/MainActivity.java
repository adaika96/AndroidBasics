package com.example.adaham.androidbasics;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static int DELTA_VALUE = 5;

    private static final String LOGTAG = "SeekBarDemo";

    SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
    final TextView textView = findViewById(R.id.textView);

    Button buttonDecrease = findViewById(R.id.button_decrease);
    Button buttonIncrease = findViewById(R.id.button_increase);

    String text = "Progress: " + seekBar.getProgress() + "/" + seekBar.getMax();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView.setText(text);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            //When Prgress Value Changed
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                textView.setText(text);
                Log.i(LOGTAG, "Changing seekBar's progress");
                Toast.makeText(getApplicationContext(),"Changing seekBar's progress", Toast.LENGTH_SHORT).show();
            }

            // Notification that the user has started a touch gesture.
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i(LOGTAG, "Started tracking seekBar");
                Toast.makeText(getApplicationContext(), "Started tracking seekBar",Toast.LENGTH_SHORT).show();

            }
            // Notification that the user has finished a touch gesture
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String textProgress = "Progress: " + progress + "/" + seekBar.getMax();
                textView.setText(textProgress);
                Log.i(LOGTAG, "Stopped tracking seekbar");
                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();

            }
        });


        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreateProgress();
            }
        });

        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increateProgress();
            }
        });

    }

    private void decreateProgress() {
        int progress = this.seekBar.getProgress();
        if (progress - DELTA_VALUE < 0) {
            seekBar.setProgress(0);
        } else {
            seekBar.setProgress(progress - DELTA_VALUE);
        }
        textView.setText(text);
    }

    private void increateProgress() {
        int progress= seekBar.getProgress();
        if(progress + DELTA_VALUE > seekBar.getMax())  {
            seekBar.setProgress(0);
        }else {
            seekBar.setProgress(progress + DELTA_VALUE);
        }
        textView.setText(text);
    }
}
