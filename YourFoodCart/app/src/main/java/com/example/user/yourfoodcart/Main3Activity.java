package com.example.user.yourfoodcart;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main3Activity extends AppCompatActivity {
EditText un,pass;
Button Sub,lg;
TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        un=findViewById(R.id.un);
        pass=findViewById(R.id.pss);
        Sub = findViewById(R.id.sub);
tv2=findViewById(R.id.tv2);
lg = findViewById(R.id.lg2);

tv2.setVisibility(View.INVISIBLE);
lg.setVisibility(View.INVISIBLE);
        Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos;
                String f = "YourId.txt";
                String a = String.valueOf(un.getText());
                String b = String.valueOf(pass.getText());
                String c = a+":"+b+"\r\n";

                try {
                    fos =openFileOutput(f, Context.MODE_APPEND);
                    fos.write(c.getBytes());


                    tv2.setVisibility(View.VISIBLE);
                    lg.setVisibility(View.VISIBLE);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                lg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                            Intent i=new Intent(Main3Activity.this,Main2Activity.class);
                            startActivity(i);
                        }catch(Exception e ){
                            e.printStackTrace();
                        }
                    }

                });
        }});



    }
}
