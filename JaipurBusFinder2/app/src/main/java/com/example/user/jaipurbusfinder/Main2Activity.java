package com.example.user.jaipurbusfinder;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class Main2Activity extends AppCompatActivity {
Button search ;
    FrameLayout frame;
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        search = findViewById(R.id.tofrg);
        frame = findViewById(R.id.frame);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment sec = AfterSearch.newInstance();
                ft.replace(R.id.l1, sec);
                ft.commit();
                }
        });


    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
       ft.remove(AfterSearch.newInstance());
        ft.commit();
    }
}
