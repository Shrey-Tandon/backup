package com.example.user.orderfoodonline;

import android.animation.Animator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        iv=findViewById(R.id.iv);
        Thread obj=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    Intent obj2=new Intent(MainActivity.this,Main4Activity.class);
                    startActivity(obj2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });obj.start();
        YoYo.with(Techniques.FadeIn).duration(2000).withListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {


            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //YoYo.with(Techniques.FadeIn).duration(2000).playOn(tv);
                YoYo.with(Techniques.FadeOut).duration(3000).playOn(tv);

                YoYo.with(Techniques.SlideOutUp).duration(3000).playOn(iv);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).playOn(iv);
    }
}
