package com.example.user.loginusingfh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
TextView read;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        read = findViewById(R.id.read);
        String fn = "Login usingFH.txt";
        try {
            FileInputStream fin=  openFileInput(fn);
            int size;
            String newText = null;
            while ((size=fin.read())!=-1){
                newText = newText + Character.toString((char)size);
                }

            read.setText(newText);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
