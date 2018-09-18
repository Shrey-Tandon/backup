package com.example.user.sqlliteex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Shrey" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLlite df= new SQLlite(this);
        if(df.addContact(new Contact("shrey","shrey","dvs","dsau"))){
            Toast.makeText(this, "yeppiii", Toast.LENGTH_SHORT).show();
        }
        List<Contact> get= new ArrayList<>();
        get=df.getContact();

        for(Contact a:get){
            Log.d(TAG,"onCreate : "+a.getName());
            Log.d(TAG,"onCreate : "+a.getContact());
        }
        
        
    }
}
