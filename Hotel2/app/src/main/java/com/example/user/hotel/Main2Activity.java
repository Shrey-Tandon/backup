package com.example.user.hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getIncommingIntent();
    }

    public void getIncommingIntent() {
            if (getIntent().hasExtra("item")) {
                int h =  getIntent().getExtras().getInt("item");
                setView(h);
            }
    }

    public void setView(int h) {


        ImageView img =findViewById(R.id.pic);
        img.setImageResource(MainActivity.img[h]);


        TextView rcp = findViewById(R.id.rcp);
        String[] np=MainActivity.name_price[h].split(":");
        final String name= np[0];
        final String price= np[1];
        rcp.setText(price);

        TextView rcn = findViewById(R.id.rcn);
        rcn.setText(name);

        img.setVisibility(View.VISIBLE);
        rcn.setVisibility(View.VISIBLE);
        rcp.setVisibility(View.VISIBLE);


    }
}


