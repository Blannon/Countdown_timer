package com.blannoncodes.counttimetimer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    CountDownTimer timer;
    Button start;
    TextView countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countDownTimer = findViewById(R.id.countdown_timer);
        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime();
            }
        });
    }

    private void startTime() {
        timer = new CountDownTimer(10000, 1000) { // 1000 is period you can change time
            @Override
            public void onTick(long millisUntilFinished) {
                long hours = (millisUntilFinished/ 1000) /3600;
                long minutes = ( (millisUntilFinished / 1000) % 3600 ) / 60;
                long seconds = (millisUntilFinished / 1000) % 60;

                String timerFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
                countDownTimer.setText(timerFormatted);
            }

            @Override
            public void onFinish() {
                countDownTimer.setText("00:00:00");
                Toast.makeText(MainActivity.this, "Time's up", Toast.LENGTH_SHORT).show();
                MediaPlayer alarm =MediaPlayer.create(MainActivity.this, R.raw.atemi_bebi_bebi_baby_baby_mp3_4124);
                alarm.start();

            }
        }.start();
    }
}