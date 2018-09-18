package com.example.user.tgl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
Button On;
Button Off;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        On = (Button) findViewById(R.id.On);
        Off = (Button) findViewById(R.id.Off);

        On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                On.setVisibility(View.VISIBLE);
                Off.setVisibility(View.INVISIBLE);
            }
        });

        Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Off.setVisibility(View.VISIBLE);
                On.setVisibility(View.INVISIBLE);
            }
        });
    }}


