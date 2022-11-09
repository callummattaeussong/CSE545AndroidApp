package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView MembersText = (TextView)findViewById(R.id.MembersText);
        MembersText.setText(getString(R.string.Members));

        /*** Service Activity ***/
        Button ServiceButton = (Button)findViewById(R.id.ServiceButton);
        ServiceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent serviceIntent = new Intent(MainActivity.this, ServiceActivity.class);
                view.getContext().startActivity(serviceIntent);
            }
        });
    }
}