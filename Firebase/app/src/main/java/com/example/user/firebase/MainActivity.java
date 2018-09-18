package com.example.user.firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText un;
EditText pass;
Button b1;
List<String> ft;
List<userReport> data;
DatabaseReference user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
data= new ArrayList<>()
        un=findViewById(R.id.un);
        pass=findViewById(R.id.pass);
        b1 = findViewById(R.id.b1);

        user = FirebaseDatabase.getInstance().getReference("user");

      b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               try {
                      String fid= user.push().getKey();
                      user.child(fid).setValue(new userReport(String.valueOf(un.getText()),String.valueOf(pass.getText()),fid));

               }catch(Exception e){
                   e.printStackTrace();
               }

           }});


user.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds :dataSnapshot.getChildren()){
            data.add(ds.getValue(userReport.class));

            for(userReport d:data){
                ft.add(d.getUsername()+":"+d.getPassword());
            }
        }
    }



        ArrayAdapter gh = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, )
        ls.set


    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});




    }
}




