package com.example.user.truthdare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
ImageView bottle;
Button play;
Random r;
Thread th;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = new Random();
        bottle=findViewById(R.id.bottle);
        play=findViewById(R.id.bt1);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            {
                int angle =r.nextInt()+360;
                RotateAnimation rotate = new RotateAnimation(0,angle,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotate.setFillAfter(true);
                rotate.setDuration(2000);
                rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                bottle.startAnimation(rotate);
                Thread th =  new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(2200);
                            Intent i=new Intent(MainActivity.this,Main2Activity.class);
                            startActivity(i);
                        }catch(Exception e ){
                            e.printStackTrace();
                        }
                }});
                th.start();
                play.setText("Play Again..!");
            }
        }});

        }
}
