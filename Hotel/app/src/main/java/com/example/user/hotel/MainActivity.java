package com.example.user.hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tv1;
Button menu;
Button checkout;
TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        menu = findViewById(R.id.menu);
        checkout =findViewById(R.id.co);

        tv1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread th =  new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Intent i = new Intent(MainActivity.this, Main2Activity.class);
                            startActivity(i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }});
                th.start();
           }
        });


        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread th =  new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Intent i = new Intent(MainActivity.this, Main3Activity.class);
                            startActivity(i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }});
                th.start();
           }
        });

        tv1.setVisibility(View.INVISIBLE);
    }
}
