package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;;

public class BroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter filter = new IntentFilter("com.example.homework");
        registerReceiver(new MyBroadcastReceiver(),filter);
        setContentView(R.layout.activity_broadcast);
    }

    public void onBroadcastIntent(View view) {
        Intent intent = new Intent("com.example.homework");
        intent.putExtra("msg", "Have a good day!");
        System.out.println("Sent intent");
        sendBroadcast(intent);
    }

    public void onBack(View view) {
        finish();
    }
}