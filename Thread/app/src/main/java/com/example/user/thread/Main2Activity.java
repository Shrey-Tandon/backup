package com.example.user.thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    ListView list;
    String[] data ={"Mantree ji","Toggle","Python", "Casino","Taj Mahal","il;yu,i,","yyuiyui","dfsdfds","ffsdfds","dfDddfasd","fdsfsfsef","dfdsfsf"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        list= findViewById(R.id.list);
        list.setVisibility(View.VISIBLE);
        final ArrayAdapter<String> li= new ArrayAdapter<String>(Main2Activity.this,android.R.layout.simple_dropdown_item_1line,data) ;
        list.setAdapter(li);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                   Toast.makeText(Main2Activity.this,""+data[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
