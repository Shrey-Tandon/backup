package com.example.user.customdialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Dialog d;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      d= new Dialog(MainActivity.this);

        View v = getLayoutInflater().inflate(R.layout.dialog,null);
        d.setContentView(v);

        TextView title = d.findViewById(R.id.title);
        TextView msg = d.findViewById(R.id.msg);
        Button yes =d.findViewById(R.id.yes);
        Button no =d.findViewById(R.id.no);
        d.getWindow()


        title.setText("lCO");
        msg.setText("Learn Code Online");


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Thankyou",Toast.LENGTH_LONG);
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Thankyou for Coming ",Toast.LENGTH_LONG,);
                d.dismiss();
            }
        });



    button=findViewById(R.id.button);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            d.show();
        }
    });






    }
}
