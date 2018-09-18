package com.example.user.nplay;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.mtechviral.mplaylib.MusicFinder;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    BottomSheetBehavior bottomSheetBehavior;
    RecyclerView rcey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View v = findViewById(R.id.bottomsheet);
        bottomSheetBehavior=BottomSheetBehavior.from(v);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View v, int i) {
                if(BottomSheetBehavior.STATE_EXPANDED==i){
                    Toast.makeText(MainActivity.this, "expanded", Toast.LENGTH_SHORT).show();
                }
                if(BottomSheetBehavior.STATE_COLLAPSED==i){
                    Toast.makeText(MainActivity.this, "collapsed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
        rcey=findViewById(R.id.recy);
        rcey.setLayoutManager(new GridLayoutManager(MainActivity.this,2));

       rcey.setAdapter(new Rcadapter(this,getMusics()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkPermission()) {
            } else {
                String[] per = {Manifest.permission.READ_EXTERNAL_STORAGE};
                requestPermissions(per, 1000);
            }

        }


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1000){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Required Permissions Granted", Toast.LENGTH_SHORT).show();
            }
        }
        else {finish();}

    }

    public boolean checkPermission() {
        boolean isOn = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                isOn = true;
            } else {
                isOn = false;
            }
        }
        return isOn;
    }

    private List<MusicFinder.Song> getMusics(){
        MusicFinder songFinder= new MusicFinder(getContentResolver());
        songFinder.prepare();
        List<MusicFinder.Song> songs=songFinder.getAllSongs();
        System.out.println(songs.size());
     for(MusicFinder.Song song:songs) {
         System.out.println(song.getTitle());
         System.out.println(song.getArtist());
     } return songs;
    }

}
