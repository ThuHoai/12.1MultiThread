package com.example.hoaiktt.bai2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.hoaiktt.a12multithread.Flipper;
import com.example.hoaiktt.a12multithread.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void buttonHandler(View clickButton){
        ExecutorService taskList = Executors.newFixedThreadPool(10);
        for (int i=0; i<5; i++){
            taskList.execute(new Flipper(1000));
        }
    }
}
