package com.example.user.hotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
        public static  int[] img = {R.drawable.pasta,R.drawable.macaroni,R.drawable.hotdog,
                R.drawable.barbeque,R.drawable.noodles,R.drawable.pizza,R.drawable.sandwhc,
                R.drawable.vegrolls,R.drawable.indianthali,R.drawable.burger};

        public static  String[] name_price = {"pasta:75 rs/-","macaroni:75 rs/-","hotdog:35 rs/-","barbeque:150 rs/-","noodles:135 rs/-","pizza:99 rs/-","sandwhc:45 rs/-","vegrolls:65 rs/-","indianthali:120 rs/-","burger:65 rs/-"};
        RecyclerView recyclerView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            recyclerView=findViewById(R.id.rcy);
            recyclerView.setLayoutManager(new GridLayoutManager(this,1));
            recyclerView.setAdapter(new RcAdapter(img,name_price,this));


        }
}
