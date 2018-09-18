package com.example.user.customtoast;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView  tv1;
Button b1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
b1 = findViewById(R.id.b1);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LayoutInflater li = getLayoutInflater();
                    //Getting the View object as defined in the customtoast.xml file
                    View layout = li.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.custom_toast_layout));

                    //Creating the Toast object
                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.setView(layout);//setting the view of custom toast layout
                    toast.show();
                }
            });

        }}