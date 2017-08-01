package com.example.hoaiktt.a12multithread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private Button mBtnFlipperCoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnFlipperCoin= (Button) findViewById(R.id.btn_flipper_coin);
        mBtnFlipperCoin.setOnClickListener(new ClickFlipperCoin());

    }

    private class ClickFlipperCoin implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            ExecutorService taskList = Executors.newFixedThreadPool(100);
            for(int i=0;i<5;i++){
                String threadName = Thread.currentThread().getName();
                taskList.execute(new Flipper());
            }
        }
    }
}
