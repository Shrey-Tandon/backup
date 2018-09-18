package com.example.user.bulbglowingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button off,onn;
ImageView i1,i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        off=findViewById(R.id.b1);
        onn=findViewById(R.id.b2);
        i1=findViewById(R.id.imageView);
        i2=findViewById(R.id.imageView2);
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i1.animate().alpha(1).setDuration(1000);
                i2.animate().alpha(0).setDuration(1000);
            }
        });
        onn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i1.animate().alpha(0).setDuration(1000);
                i2.animate().alpha(1).setDuration(1000);

            }
        });


    }
}
