package com.example.user.yourfoodcart;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
EditText un;
EditText pass;
Button loginb,SignUp;
TextView tv;
boolean  flag= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        un=findViewById(R.id.un);
        pass=findViewById(R.id.pss);
        loginb =  findViewById(R.id.lb);
        SignUp = findViewById(R.id.up);
tv=findViewById(R.id.tv);
        tv.setVisibility(View.INVISIBLE);
        SignUp.setVisibility(View.INVISIBLE);

        loginb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{String a= un.getText().toString();
                String b = pass.getText().toString();

                String c = a+":"+b;
                String f = "YourId.txt";
                try {
                    FileInputStream fin;
                    fin = openFileInput(f);
                    int  size;
                    String ntext = null;
                    while((size=fin.read())!=-1) {
                        ntext = ntext + Character.toString((char) size);
                    }
                    String[] data = ntext.split("\r\n");
                    for(String d : data){
                        if(c.equals(d)){
                            flag=true;
                        }
                    }
                    if(flag){
                        Toast.makeText(Main2Activity.this,"Login Successfull..!! please Enjoy Our Food",Toast.LENGTH_LONG).show();
                        Intent i=new Intent(Main2Activity.this,Main4Activity.class);
                        startActivity(i);
                    }else{
                        tv.setVisibility(View.VISIBLE);
                        SignUp.setVisibility(View.VISIBLE);
                        Toast.makeText(Main2Activity.this,"Login Unsuccessfull..! please sign Up first..!",Toast.LENGTH_LONG).show();
                    }


                }
 catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }catch (Exception e){
                e.printStackTrace();
                }
            }
        });



        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(i);
            }
        });



    }
}
