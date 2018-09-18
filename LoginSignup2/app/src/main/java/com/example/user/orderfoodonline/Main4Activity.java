package com.example.user.orderfoodonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {
Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        bt1=findViewById(R.id.bt6);
        bt2=findViewById(R.id.bt5);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread obj=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            Intent obj1=new Intent(Main4Activity.this,Main5Activity.class);
                            startActivity(obj1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });obj.start();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread obj=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            Intent obj1=new Intent(Main4Activity.this,Main6Activity.class);
                            startActivity(obj1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                });obj.start();
            }
        });
    }
}
