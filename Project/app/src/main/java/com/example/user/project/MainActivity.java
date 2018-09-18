package com.example.user.project;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.*;

public class MainActivity extends AppCompatActivity {
android.support.v7.widget.Toolbar t1;
Button b1;
Dialog d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.b1);
        t1=findViewById(R.id.toolbar);
        t1.setTitleTextColor(Color.WHITE);
        setSupportActionBar(t1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder d=new AlertDialog.Builder(MainActivity.this);
                d.setTitle("You have pressed the Button..!");
                d.show();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "you have selected item 1", Toast.LENGTH_SHORT).show();
                break;
                case R.id.item2:
                Toast.makeText(this, "you have selected item 2", Toast.LENGTH_SHORT).show();
                break;
                case R.id.item3:
                Toast.makeText(this, "you have selected item 3", Toast.LENGTH_SHORT).show();
                break;


        }



        return super.onOptionsItemSelected(item);
    }
}
