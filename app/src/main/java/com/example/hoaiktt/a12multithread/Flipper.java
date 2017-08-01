package com.example.hoaiktt.a12multithread;

import android.util.Log;

import java.util.Random;
import java.util.regex.Matcher;

/**
 * Created by hoaiktt on 8/1/2017.
 */

public class Flipper implements Runnable{
    private static final int COIN = 1000;
    @Override
    public void run() {
        int x =0;
        for(int i = 0;i<COIN; i++){
           int k = randomInt(2);
            if(k==1){
                x++;
                if(x>=3){
                    for(int j=i-x+1;j<=i;j++){
                        String name = Thread.currentThread().getName();
                        Log.e("Flipper",name + String.valueOf(j));
                    }
                    x=0;
                }

            }else if(k==0){
                x =0;
            }
        }
    }

    private int randomInt(int n){
        Random random = new Random();
        return (random.nextInt(n));
    }

}
