package com.example.user.loginusingfh;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
EditText un;
EditText pass;
Button Sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
un=findViewById(R.id.un);
pass=findViewById(R.id.pss);
Sub = findViewById(R.id.sub);

Sub.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FileOutputStream fos;
        String fn = "Login usingFH.txt";
        String a = String.valueOf(un.getText());
        String b = String.valueOf(pass.getText());
        String c = a+":"+b+"\r\n";

        try {
            fos =openFileOutput(fn, Context.MODE_APPEND);
            fos.write(c.getBytes());


            Thread th =  new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(1000);
                        Intent i=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(i);
                    }catch(Exception e ){
                        e.printStackTrace();
                    }
                }
            });

            th.start();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
});

    }
}
