package com.example.hoaiktt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.hoaiktt.a12multithread.Flipper;
import com.example.hoaiktt.a12multithread.R;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main3Activity extends AppCompatActivity implements Runnable {
    private static final int mLoppLiMit = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void buttonHandler(View clickButton){
        ExecutorService taskList = Executors.newFixedThreadPool(10);
        for (int i=0; i<5; i++){
            taskList.execute(this);
        }
    }
    @Override
    public void run() {
        Random random = new Random();
        int x = 0;
        for (int i = 0; i < mLoppLiMit; i++) {
            int coin = random.nextInt(2);
            if (coin == 1) {
                x++;
                if (x >= 3) {
                    for (int j = i - x + 1; j <= i; j++) {
                        String threadName = Thread.currentThread().getName();
                        Log.i("Flipper",threadName +i);
                        Log.e("Flipper",String.valueOf(j));
                    }
                    x = 0;
                }
            } else {
                x = 0;
            }
        }
    }
}
