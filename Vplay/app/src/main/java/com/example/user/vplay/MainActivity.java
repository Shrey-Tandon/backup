package com.example.user.vplay;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.mtechviral.mplaylib.MusicFinder;

import java.util.List;

import static com.example.user.vplay.R.id.bottomsheet;

public class MainActivity extends AppCompatActivity {

    BottomSheetBehavior bottomSheetBehavior;
    RecyclerView rec;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         rec=findViewById(R.id.rec);



        View v=findViewById(R.id.bottomsheet);
        bottomSheetBehavior=BottomSheetBehavior.from(v);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                if (BottomSheetBehavior.STATE_EXPANDED==i){
                    Toast.makeText(MainActivity.this, "expanded", Toast.LENGTH_SHORT).show();
                }
                if (BottomSheetBehavior.PEEK_HEIGHT_AUTO==i){
                    Toast.makeText(MainActivity.this, "peek auto height", Toast.LENGTH_SHORT).show();
                }
                if (BottomSheetBehavior.STATE_COLLAPSED==i){
                    Toast.makeText(MainActivity.this, "collapsed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });

        rec.setLayoutManager(new GridLayoutManager(this,2));
        rec.setAdapter(new Recycler_adapter(this,getMusics()));




        String[] per={Manifest.permission.READ_EXTERNAL_STORAGE}
                ;
        requestPermissions(per,1000);
        if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){

        }else finish();

    }
    private List<MusicFinder.Song> getMusics(){
        MusicFinder songFinder = new MusicFinder(getContentResolver());
        songFinder.prepare();
        List<MusicFinder.Song> songs = songFinder.getAllSongs();


        return songs;
    }
}
