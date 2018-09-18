package com.example.user.orderfoodonline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import static android.app.PendingIntent.getActivity;

public class Main6Activity extends AppCompatActivity {

EditText e1,e2;
Button b1;
    String fname;
    String fcontent;
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
       e1= findViewById(R.id.editText3);
       e2=findViewById(R.id.editText4);
       b1=findViewById(R.id.button8);



b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FileOutputStream outputStream;
        String filename = "User ID.txt";
        File obj=new File("useriID.txt");
        String a=String.valueOf(e1.getText());
        String b=String.valueOf(e2.getText());
        String c=a+":"+b+"\r\n";

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(c.getBytes());
            outputStream.close();
            Toast.makeText(Main6Activity.this, "Congrats You are our new costumer !!"+"\r\n"+"Enjoy The Food", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(Main6Activity.this, "Something Went Wrong"+"\r\n"+"Please try again Soon!!", Toast.LENGTH_SHORT).show();
        }
    }  Thread th=new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                Intent obj1=new Intent(Main6Activity.this,Main5Activity.class);
                startActivity(obj1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }th.start();

        }
    });

});


}}

