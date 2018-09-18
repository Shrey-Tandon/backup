package com.example.user.yourfoodcart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {
    public static  int[] img = {R.drawable.pasta,R.drawable.macaroni,R.drawable.hotdog,
            R.drawable.barbeque,R.drawable.noodles,R.drawable.pizza,R.drawable.sandwhc,
            R.drawable.vegrolls,R.drawable.indianthali,R.drawable.burger};
    public static Button cartbtn,checkout;


    public static  String[] name_price = {"pasta:75","macaroni:75","hotdog:35","barbeque:150","noodles:135","pizza:99","sandwhc:45","vegrolls:65","indianthali:120","burger:65"};
    RecyclerView recyclerView;
    public static List<Integer> cart;
    public static List<Integer> bynow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        checkout=findViewById(R.id.checkout);
        cartbtn=findViewById(R.id.cart);
        recyclerView=findViewById(R.id.rcy);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(new RcAdapter(img,name_price,this));
        cart= new ArrayList<>();

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ij=new Intent(Main4Activity.this,Main6Activity.class);
                startActivity(ij);

            }
        });

        cartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ij=new Intent(Main4Activity.this,Main7Activity.class);
                startActivity(ij);

            }
        });

    }
}
