package com.example.user.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button deci ;
    Button del ;
    Button div ;
    Button multi ;
    Button add ;
    Button subs ;
    Button equal ;
    TextView dis;
    Button zero;
    double first,second,result;
    boolean addition =false,
            substraction=false,
            division =false,
            multiplication=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
try{
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        deci = (Button) findViewById(R.id.deci);
        equal = (Button) findViewById(R.id.equals);
        del = (Button) findViewById(R.id.del);
        multi = (Button) findViewById(R.id.multi);
        div = (Button) findViewById(R.id.div);
        subs = (Button) findViewById(R.id.subs);
        add = (Button) findViewById(R.id.add);
        zero = (Button) findViewById(R.id.zero);

        dis = (TextView) findViewById(R.id.dis);

        dis.setText("");

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis.append("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis.append("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis.append("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis.append("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis.append("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis.append("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis.append("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis.append("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis.append("9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis.append("0");
            }
        });
        deci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis.append(".");
            }});
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    first=Double.valueOf(dis.getText().toString());
                    dis.setText(null);
                    addition=true;
                    substraction=false;
                    multiplication=false;
                    division=false;

                }catch (Exception e){ }}});


        subs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    first=Double.valueOf(dis.getText().toString());
                    dis.setText(null);
                    addition=false;
                    substraction=true;
                    multiplication=false;
                    division=false;

                }catch (Exception e){ }
            }});
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    first=Double.valueOf(dis.getText().toString());
                    dis.setText(null);
                    addition=false;
                    substraction=false;
                    multiplication=false;
                    division=true;

                }catch (Exception e){ }
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    first=Double.valueOf(dis.getText().toString());
                    dis.setText(null);
                    addition=false;
                    substraction=false;
                    multiplication=true;
                    division=false;

                }catch (Exception e){ }
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String get=dis.getText().toString();
                    dis.setText(get.substring(0,get.length()-1));
                }catch (Exception e){}
            }});

        del.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                dis.setText("");
                return true;
            }});

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    second = Double.valueOf(dis.getText().toString());
                    if(addition){
                        result =first + second;
                        dis.setText((""+result));
                    }
                    else if(substraction){
                        result =first - second;
                        dis.setText((""+result));
                    }else if(multiplication){
                        result =first * second;
                        dis.setText((""+result));
                    }else if(division){
                        result =first / second;
                        dis.setText((""+result));
                    }
                }catch (Exception e){}
            }
        });}catch(Exception e){}}}
