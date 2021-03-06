package com.eatx.wdj.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eatx.wdj.R;
import com.google.android.material.snackbar.Snackbar;
import com.royrodriguez.transitionbutton.TransitionButton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Check extends AppCompatActivity {
    private TextView date , time;
    private final Handler handler = new Handler();
    private TransitionButton checkstate;
    private TimerTask updateTime;
    private String getTim;
    private Button check;
    long now = System.currentTimeMillis();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        updateTime();

        checkstate = findViewById(R.id.checkState);
        checkstate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CheckActivity.class);
                startActivity(intent);
            }
        });

        check = findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),"출석이 완료되었습니다",Snackbar.LENGTH_SHORT);
                snackbar.setAnchorView(findViewById(android.R.id.content));
                snackbar.show();
            }
        });
    }
    public void updateTime() {
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일");
        String getDate = simpleDate.format(mDate);

        date = findViewById(R.id.date);
        date.setText(getDate);
        time = findViewById(R.id.time);
        updateTime = new TimerTask() {
            @Override
            public void run() {
                Update();
            }
        };
        Timer timer = new Timer();
        timer.schedule(updateTime, 0, 1000);
    }
    protected void Update() {
        Runnable updater = new Runnable() {
            public void run() {
                long currentTime = System.currentTimeMillis();
                Date mTime = new Date(currentTime);
                SimpleDateFormat getTime = new SimpleDateFormat("aa h시 mm분 ss초");
                getTim = getTime.format(mTime);
                time.setText(getTim);
            }
        };
        handler.post(updater);
    }
}