package com.example.user.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
FrameLayout frame;
Button pre , next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

frame= findViewById(R.id.frame);
pre = findViewById(R.id.pre);
next = findViewById(R.id.next);


pre.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment sec=first.newInstance();
        ft.replace(R.id.frame,sec);
        ft.commit();
    }
});

next.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fir=second.newInstance();
        ft.replace(R.id.frame,fir);
        ft.commit();
    }
});

    }
}
