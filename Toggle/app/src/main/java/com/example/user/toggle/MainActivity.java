package com.example.user.toggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity { {

        String editString="";

        Button btn;
        EditText ed;
        ToggleButton toggle;
        @Override
        protected void onCreate(Bundle) {
            super.onCreate();
    setContentView(R.layout.activity_main);
    btn = findViewById(R.id.btn);
    ed = findViewById(R.id.ed);
    toggle = findViewById(R.id.toggBtn);

    editString = ed.getText().toString();

    btn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            toggle.Toggle();
            if (editString.equals("1")) {

                toggle.setTextOff("TOGGLE ON");

            } else if (editString.equals("0")) {

                toggle.setTextOn("TOGGLE OFF");

            }
        }
    });
        }
    }