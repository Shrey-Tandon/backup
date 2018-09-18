package com.example.user.jaipurbusfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);


                Thread th =  new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Thread.sleep(1500);
                            Intent i=new Intent(MainActivity.this,Main2Activity.class);
                            startActivity(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                });


                th.start();
            }}