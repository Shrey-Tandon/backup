package com.example.user.recorder;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.security.Permission;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
Button play,pause,stop,rec;
MediaRecorder mediaRecorder;
String path;
MediaPlayer mp;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if(requestCode==1000){
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED
                        && grantResults[1]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "All Required Permissions Granted", Toast.LENGTH_SHORT).show();
                }
            }
            else {finish();}

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recorder);

        pause=findViewById(R.id.pause);
        play=findViewById(R.id.play);
        stop=findViewById(R.id.stop);
        rec=findViewById(R.id.rec);


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(checkPermission()){}
            else{
                String[] per={Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.RECORD_AUDIO};
                requestPermissions(per,1000);
            }

        }


         final File dir;
        dir = new File(Environment.getExternalStorageDirectory(),"/audio/");
        if(!dir.exists()) {
            dir.mkdir();

            pause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mp=new MediaPlayer();
                    try{
                        mp.setDataSource(path);
                        mp.prepare();
                        mp.start();

                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            });
            stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mediaRecorder != null) {
                        mediaRecorder.stop();
                        mediaRecorder.release();
                    }
                    if(mp!=null){
                        mp.stop();
                        mp.release();
                    }
                }
            });
            rec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    path = dir.getAbsolutePath() + "/" + UUID.randomUUID() + ".3gp";
                    RecorderSetup(path);
                    try {
                        mediaRecorder.prepare();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    mediaRecorder.start();


                }
            });
        }else{
            pause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mp=new MediaPlayer();
                    try{
                        mp.setDataSource(path);
                        mp.prepare();
                        mp.start();

                    }catch (IOException e){
                        e.printStackTrace();
                    }

                }
            });

           stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mediaRecorder != null) {
                        mediaRecorder.stop();
                        mediaRecorder.release();
                        Toast.makeText(MainActivity.this, "Stoped", Toast.LENGTH_SHORT).show();

                    }if(mp!=null){
                        mp.stop();
                        mp.release();
                    }
                }
            });
            rec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    path = dir.getAbsolutePath() + "/" + UUID.randomUUID() + ".3gp";
                    RecorderSetup(path);
                    Toast.makeText(MainActivity.this, "recording stared", Toast.LENGTH_SHORT).show();
                    try {
                        mediaRecorder.prepare();
                        mediaRecorder.start();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            });
        }
    }

    public void RecorderSetup(String path){
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.setOutputFile(path);
    }

        public boolean checkPermission() {
            boolean isOn = false;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                        checkSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                    isOn = true;
                } else {
                    isOn = false;
                }
            }
            return isOn;
        }



}
