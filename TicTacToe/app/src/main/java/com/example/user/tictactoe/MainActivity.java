package com.example.user.tictactoe;

import android.animation.Animator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {
Button bt1;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 =findViewById(R.id.bt1);
        tv = findViewById(R.id.tv);
        tv.setVisibility(View.VISIBLE);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Thread th =  new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(1000);
                        Intent i=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(i);
                    }catch(Exception e ){
                        e.printStackTrace();
                    }
                }
            });

                th.start();
            }
        });
        YoYo.with(Techniques.SlideOutUp).duration(1000).withListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                YoYo.with(Techniques.BounceInUp).duration(1000).playOn(tv);
                YoYo.with(Techniques.RubberBand).duration(2000).playOn(bt1);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).playOn(tv);

    }
}