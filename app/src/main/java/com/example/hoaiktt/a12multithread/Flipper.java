package com.example.hoaiktt.a12multithread;

import java.util.Random;
import java.util.regex.Matcher;

/**
 * Created by hoaiktt on 8/1/2017.
 */

public class Flipper implements Runnable{
    private static final int COIN = 1000;
    private final int mLoopLimit = 5;

    @Override
    public void run() {
        for(int i = 0;i<COIN; i++){
            int x =0;
           int k = randomInt(2);
            if(k==0){
                x++;
                if(x>=3){
                    for(int j=i-x;j<mLoopLimit;j++){

                    }
                }

            }else if(k==1){
                x =0;
            }
        }
    }

    private int randomInt(int n){
        Random random = new Random();
        return (random.nextInt(n));
    }

}
