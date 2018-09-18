package com.example.user.thread;

import android.animation.Animator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    LinearLayout ln;
    ImageView  im;
    TextView tv1, tv2;
    int i=0;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            im=findViewById(R.id.con1);
            ln=findViewById(R.id.con2);
            tv1=findViewById(R.id.tv1);
            tv2=findViewById(R.id.tv2);



            Thread th =  new Thread(new Runnable() {
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
        YoYo.with(Techniques.FadeIn).duration(2000).withListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                YoYo.with(Techniques.Landing).duration(3000).playOn(im);
                YoYo.with(Techniques.SlideOutUp).duration(3000).playOn(ln);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).playOn(im);


    }}
