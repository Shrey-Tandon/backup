package com.example.user.orderfoodonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Main7Activity extends AppCompatActivity {
ListView lv;
Button b1;
TextView tv1;
int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        lv= findViewById(R.id.lv);

         b1= findViewById(R.id.bt10);
        tv1=findViewById(R.id.textView5);



        String[] food={"Cake  :-$100","Coke  :-$10","Pizza  :-$300","Pasta   :-$56","Burger  :-$70"};
        ArrayAdapter<String> obj=new ArrayAdapter<String>(Main7Activity.this,android.R.layout.simple_dropdown_item_1line,food);
        lv.setAdapter(obj);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    a=a+100;

                }else if (position==1){
                 a=a+10;
                }else if (position==2){
                    a=a+300;

                }else if (position==3){
                    a=a+56;


                }else if (position==4){
                    a=a+70;


                }
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tv1.setText("Please Pay the bill of "+a);
                    }
                });
            }
        });
    }
}
