package com.example.user.dice;

import java.util.Random;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.random;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView, tv1, tv2, tv3, tv4, tv5, tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);


        tv1.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv3.setVisibility(View.INVISIBLE);
        tv4.setVisibility(View.INVISIBLE);
        tv5.setVisibility(View.INVISIBLE);
        tv6.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min = 1;
                int max = 6;
                int random = ThreadLocalRandom.current().nextInt(min, max + 1);
                try {if (random == 1) {
                    tv1.setVisibility(View.VISIBLE);
                    tv2.setVisibility(View.INVISIBLE);
                    tv3.setVisibility(View.INVISIBLE);
                    tv4.setVisibility(View.INVISIBLE);
                    tv5.setVisibility(View.INVISIBLE);
                    tv6.setVisibility(View.INVISIBLE);
                } else if (random == 2) {
                    tv1.setVisibility(View.INVISIBLE);
                    tv2.setVisibility(View.VISIBLE);
                    tv3.setVisibility(View.INVISIBLE);
                    tv4.setVisibility(View.INVISIBLE);
                    tv5.setVisibility(View.INVISIBLE);
                    tv6.setVisibility(View.INVISIBLE);
                } else if (random == 3) {
                    tv1.setVisibility(View.INVISIBLE);
                    tv2.setVisibility(View.INVISIBLE);
                    tv3.setVisibility(View.VISIBLE);
                    tv4.setVisibility(View.INVISIBLE);
                    tv5.setVisibility(View.INVISIBLE);
                    tv6.setVisibility(View.INVISIBLE);
                } else if (random == 4) {
                    tv1.setVisibility(View.INVISIBLE);
                    tv2.setVisibility(View.INVISIBLE);
                    tv3.setVisibility(View.INVISIBLE);
                    tv4.setVisibility(View.VISIBLE);
                    tv5.setVisibility(View.INVISIBLE);
                    tv6.setVisibility(View.INVISIBLE);
                } else if (random == 5) {
                    tv1.setVisibility(View.INVISIBLE);
                    tv2.setVisibility(View.INVISIBLE);
                    tv3.setVisibility(View.INVISIBLE);
                    tv4.setVisibility(View.INVISIBLE);
                    tv5.setVisibility(View.VISIBLE);
                    tv6.setVisibility(View.INVISIBLE);
                } else if (random == 6) {
                    tv1.setVisibility(View.INVISIBLE);
                    tv2.setVisibility(View.INVISIBLE);
                    tv3.setVisibility(View.INVISIBLE);
                    tv4.setVisibility(View.INVISIBLE);
                    tv5.setVisibility(View.INVISIBLE);
                    tv6.setVisibility(View.VISIBLE);
                }

                } catch (Exception e) {
                }
            }
        });
    }}




