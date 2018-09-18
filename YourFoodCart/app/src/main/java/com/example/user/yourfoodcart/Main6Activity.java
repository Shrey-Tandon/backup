package com.example.user.yourfoodcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {
TextView tvOut,pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        tvOut=findViewById(R.id.tvOut);
        pay=findViewById(R.id.pay);
        tvOut.setText("your Amount To be paid is : "+Main5Activity.amt);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOut.setText("Thanks For Selecting Us..!!");
                pay.setVisibility(View.INVISIBLE);
                Toast.makeText(Main6Activity.this, "Your Order has been successfully placed..!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
