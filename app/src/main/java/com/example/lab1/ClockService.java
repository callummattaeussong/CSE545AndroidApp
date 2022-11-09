package com.example.lab1;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class ClockService extends Service {

    private final IBinder mBinder = new LocalBinder();
    private HandlerThread mHandlerThread;
    private Handler mHandler;

    public class LocalBinder extends Binder {
        ClockService getService() {
            return ClockService.this;
        }
    }

    public ClockService() {
    }

    public String getTime(){
        String TimeString = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zdt = ZonedDateTime.now(zoneId);

            TimeString = zdt.getHour() + " : " + zdt.getMinute();
        }else{
            Date d = new Date();
            TimeString = d.getHours() + " : " + d.getMinutes();
        }
        return TimeString;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }
}