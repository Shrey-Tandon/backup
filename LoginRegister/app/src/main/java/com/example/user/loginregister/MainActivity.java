package com.example.user.loginregister;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.security.cert.PolicyNode;

public class MainActivity extends AppCompatActivity {
EditText username;
EditText password;
TextView tv;
Button login ;
Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.ed1);
        password=findViewById(R.id.ed2);
        tv=findViewById(R.id.tv1);
        login=findViewById(R.id.login);
        reg=findViewById(R.id.reg);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream outputStream;
                String filename = "User ID.txt";
                File obj=new File("useriID.txt");
                String a=String.valueOf(username.getText());
                String b=String.valueOf(password.getText());
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



    }
}
