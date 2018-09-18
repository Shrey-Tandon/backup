package com.example.user.table;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView t1;
Button pre;
Button next;
Button sub;
int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    pre = findViewById(R.id.pre);
    next= findViewById(R.id.next);
    t1= findViewById(R.id.t1);
    sub =findViewById(R.id.sub);
    String ip=t1.getText().toString();
    num=Integer.parseInt(ip);

    sub.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for(int i=1;  i<=10;i++){
                t1.append((num+" * "+i+" = "+(num*i)+"\n"));
        }
    }});




    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            t1.setText(null);
            num++;
            for (int i = 1; i <= 10; i++) {
                t1.append((num + " * " + i + " = " + (num * i) + "\n"));
            }
        }});

    pre.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            t1.setText(null);
           num--;
            for(int i=1;  i<=10;i++){
                t1.append((num+" * "+i+" = "+(num*i)+"\n"));
            }

        }
    });
}
}