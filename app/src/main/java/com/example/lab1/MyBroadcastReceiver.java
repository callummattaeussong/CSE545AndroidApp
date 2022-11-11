package com.example.lab1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("Recieved intent");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(context,"Current Time: " + new ClockService().getTime()+ "\n  " + intent.getStringExtra("msg"),Toast.LENGTH_LONG).show();
            }
        });
    }
}