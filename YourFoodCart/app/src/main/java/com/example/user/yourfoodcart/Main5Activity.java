package com.example.user.yourfoodcart;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {
    Button AddToCart,BuyNow;
    public  static int amt;
    public static String price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        AddToCart= findViewById(R.id.addtocart);
        BuyNow = findViewById(R.id.Buynow);
        getIncommingIntent();

    }



    public void getIncommingIntent() {
        if (getIntent().hasExtra("item")) {
            final int h =  getIntent().getExtras().getInt("item");
            setView(h);


            AddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Main4Activity.cart.add(h);
                AddToCart.setText("Item Added to Cart");
                AddToCart.setBackgroundResource(R.drawable.btpress);
                AddToCart.setTextColor(Color.BLACK);
                Toast.makeText(Main5Activity.this, "You can add more items ", Toast.LENGTH_SHORT).show();
                amt=amt+(Integer.parseInt(price));

            }
        });
        BuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ij=new Intent(Main5Activity.this,Main6Activity.class);
                startActivity(ij);
                amt=amt+(Integer.parseInt(price));

            }
        });

        }
    }
    public void setView(int h) {


        ImageView img =findViewById(R.id.pic);
        img.setImageResource(Main4Activity.img[h]);


        TextView rcp = findViewById(R.id.rcp);
        String[] np=Main4Activity.name_price[h].split(":");
        final String name= np[0];
        price= np[1];
        rcp.setText(price+" Rs/-");

        TextView rcn = findViewById(R.id.rcn);
        rcn.setText(name);

        img.setVisibility(View.VISIBLE);
        rcn.setVisibility(View.VISIBLE);
        rcp.setVisibility(View.VISIBLE);


    }
}
