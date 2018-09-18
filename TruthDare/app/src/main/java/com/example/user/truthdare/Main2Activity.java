package com.example.user.truthdare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
TextView tv1;
Button truth;
Button dare;
TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1=findViewById(R.id.tv1);
        truth=findViewById(R.id.truth);
        dare=findViewById(R.id.dare);
        tv2 = findViewById(R.id.tv2);
        tv2.setVisibility(View.VISIBLE);
        tv1.setVisibility(View.VISIBLE);
        truth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("you have selected Truth..!");
                Toast.makeText(getApplicationContext(),"Truth is Selected..!",Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"press back button to get to the previous screen ",Toast.LENGTH_SHORT).show();

            }
        });

        dare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("you have selected Dare..!");
                Toast.makeText(getApplicationContext(),"Dare is selected..!!",Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"press back button to get to the previous screen ",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
