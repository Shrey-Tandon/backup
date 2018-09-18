package com.example.user.tglbtn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

ToggleButton tglbtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tglbtn = findViewById(R.id.tglbtn);
        tglbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Toggle On..!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Toggle Off..!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }}
