package com.example.hoaiktt.a12multithread;

import android.util.Log;

import com.example.hoaiktt.Main3Activity;

import java.util.Random;
import java.util.regex.Matcher;

/**
 * Created by hoaiktt on 8/1/2017.
 */

public class Flipper implements Runnable {
    private final int LOOPLIMIT;

    public Flipper(int LOOPLIMIT) {
        this.LOOPLIMIT = LOOPLIMIT;
    }

    @Override
    public void run() {
        int x = 0;
        for (int i = 0; i < LOOPLIMIT; i++) {
            int coin = randomInt(2);
            if (coin == 1) {
                x++;
                if (x >= 3) {
                    for (int j = i - x + 1; j <= i; j++) {
                        String threadName = Thread.currentThread().getName();
                        Log.e("Flipper",String.valueOf(j));
                    }
                    x = 0;
                }
            } else {
                x = 0;
            }
        }
    }

    private int randomInt(int n) {
        Random random = new Random();
        return (random.nextInt(n));
    }

}
