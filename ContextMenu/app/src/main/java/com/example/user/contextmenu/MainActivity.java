package com.example.user.contextmenu;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ContextMenu.OnMenuItemClickListener{
    android.support.v7.widget.Toolbar t1;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button= findViewById(R.id.bt1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContextMenu menu = new ContextMenu(button);
                menu.getMenuInflater().inflate(R.menu.menu,menu.getMenu());

            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        menu.setHeaderTitle("Select The Action");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==R.id.item1){
            Toast.makeText(getApplicationContext(),"Item1 checked",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.item2){
            Toast.makeText(getApplicationContext(),"Item2 checked",Toast.LENGTH_LONG).show();
        }else if(item.getItemId()==R.id.item3){
            Toast.makeText(getApplicationContext(),"sItem3 checked",Toast.LENGTH_LONG).show();
        }else if(item.getItemId()==R.id.item4){
            Toast.makeText(getApplicationContext(),"Item4 checked",Toast.LENGTH_LONG).show();
        }else if(item.getItemId()==R.id.item5){
            Toast.makeText(getApplicationContext(),"Item5 checked",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }
}