package com.example.user.mypiano;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   private Button s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16;
    private SoundPool soundPool;
    private int sound_s1,sound_s2,sound_s3,sound_s4,sound_s5,sound_s6,sound_s7,sound_s8,sound_s9,
            sound_s10,sound_s11,sound_s12,sound_s13,sound_s14,sound_s15,sound_s16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            soundPool = new SoundPool.Builder().setMaxStreams(6).build();
        }else{
            soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC,0);
        }

        sound_s1= soundPool.load(this,R.raw.s1,1);
        sound_s2= soundPool.load(this,R.raw.s2,1);
        sound_s3= soundPool.load(this,R.raw.s3,1);
        sound_s4= soundPool.load(this,R.raw.s4,1);
        sound_s5= soundPool.load(this,R.raw.s5,1);
        sound_s6= soundPool.load(this,R.raw.s6,1);
        sound_s7= soundPool.load(this,R.raw.s7,1);
        sound_s8= soundPool.load(this,R.raw.s8,1);
        sound_s9= soundPool.load(this,R.raw.s9,1);
        sound_s10= soundPool.load(this,R.raw.s10,1);
        sound_s11= soundPool.load(this,R.raw.s11,1);
        sound_s12= soundPool.load(this,R.raw.s12,1);
        sound_s13= soundPool.load(this,R.raw.s13,1);
        sound_s14= soundPool.load(this,R.raw.s14,1);
        sound_s15= soundPool.load(this,R.raw.s15,1);
        sound_s16= soundPool.load(this,R.raw.s16,1);


        s1=findViewById(R.id.s1);
        s2=findViewById(R.id.s2);
        s3=findViewById(R.id.s3);
        s4=findViewById(R.id.s4);
        s5=findViewById(R.id.s5);
        s6=findViewById(R.id.s6);
        s7=findViewById(R.id.s7);
        s8=findViewById(R.id.s8);
        s9=findViewById(R.id.s9);
        s10=findViewById(R.id.s10);
        s11=findViewById(R.id.s11);
        s12=findViewById(R.id.s12);
        s13=findViewById(R.id.s13);
        s14=findViewById(R.id.s14);
        s15=findViewById(R.id.s15);
        s16=findViewById(R.id.s16);


        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s1,1,1,0,0,1);
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s2,1,1,0,0,1);

            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s3,1,1,0,0,1);

            }
        });

        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s4,1,1,0,0,1);

            }
        });

        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s5,1,1,0,0,1);

            }
        });

        s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s6,1,1,0,0,1);

            }
        });

        s7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s7,1,1,0,0,1);

            }
        });

        s8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s8,1,1,0,0,1);

            }
        });

        s9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s9,1,1,0,0,1);

            }
        });

        s10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s10,1,1,0,0,1);

            }
        });

        s11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s11,1,1,0,0,1);

            }
        });

        s12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s12,1,1,0,0,1);

            }
        });

        s13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s13,1,1,0,0,1);

            }
        });


        s14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s14,1,1,0,0,1);

            }
        });

        s15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s15,1,1,0,0,1);

            }
        });

        s16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_s16,1,1,0,0,1);

            }
        });







    }
}
