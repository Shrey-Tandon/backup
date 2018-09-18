package com.example.user.orderfoodonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main5Activity extends AppCompatActivity {
Button bt1;
EditText tv1,tv2;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        bt1=findViewById(R.id.button7);
        tv1=findViewById(R.id.editText);
        tv2=findViewById(R.id.editText4);
tv=findViewById(R.id.textView5);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Create File and Content
                    String FILE_NAME = "User ID.txt";




                    // Read File and Content
                    FileInputStream fin = openFileInput(FILE_NAME);
                    int size;
                    String neuText = null;

                    // read inside if it is not null (-1 means empty)
                    while ((size = fin.read()) != -1) {
                        // add & append content
                        neuText += Character.toString((char) size);
                    }

                    neuText=neuText.trim();
                    String a= String.valueOf(tv1.getText());
                    String b=String.valueOf(tv2.getText());
                    String c=a+":"+b;
                    if (neuText.contains(c)){
                        Thread obj=new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(4000);
                                    Intent obj1=new Intent(Main5Activity.this,Main7Activity.class);
                                    startActivity(obj1);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });obj.start();
                    }else {
                        Toast.makeText(Main5Activity.this, "Please Sign Up First!!!!\r\n" +
                                "Please!!! And enjoy the Food*", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception error) {
                    // Exception
                }


    }

    });
    }}