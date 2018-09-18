package com.example.punnit.bulb_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton tgb;
    ImageView i1, i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i1 = findViewById(R.id.imageView);
        i2 = findViewById(R.id.imageView2);

        tgb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                i1.animate().alpha(1).setDuration(1000);
                i2.animate().alpha(0).setDuration(1000);
            }
        });
        tgb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                i1.animate().alpha(0).setDuration(1000);
                i2.animate().alpha(1).setDuration(1000);
            }
        });
    }
}