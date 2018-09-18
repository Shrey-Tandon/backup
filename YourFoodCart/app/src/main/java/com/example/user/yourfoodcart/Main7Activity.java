package com.example.user.yourfoodcart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.user.yourfoodcart.Main4Activity.cart;

public class Main7Activity extends AppCompatActivity {
RecyclerView rey;
Button checkout;
TextView amnt,noOfiTEM;
public static int itemNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        rey=findViewById(R.id.recy);
        checkout=findViewById(R.id.ch2);
        amnt=findViewById(R.id.amountT);
        noOfiTEM =  findViewById(R.id.noofI);
        rey.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        rey.setAdapter(new Cartadpter(Main4Activity.img,Main4Activity.name_price,Main7Activity.this, cart));
        itemNo=cart.size();


        noOfiTEM.setText("Total No. of Items In Your Cart is : "+this.itemNo);
        amnt.setText("Cart Amount is :"+Main5Activity.amt+"/-Rs");





        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ij=new Intent(Main7Activity.this,Main6Activity.class);
                startActivity(ij);

            }
        });




    }
}
