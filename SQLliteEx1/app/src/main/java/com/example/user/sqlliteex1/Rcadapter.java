package com.example.user.sqlliteex1;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Rcadapter extends RecyclerView.Adapter<Rcadapter.RcHolder> {
    List<Contact> data = new ArrayList<>();
    Context context;
    String TAG="MainActivity";

    public Rcadapter(List<Contact> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RcHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_row, viewGroup, false);
        return new RcHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Rcadapter.RcHolder hc, int i) {
        final Contact single = data.get(i);
        hc.nametv2.setText(single.getName());
        hc.numbertv2.setText(single.getContact());
        single.getName().charAt(0);
        hc.imagetv2.setText( ""+single.getName().charAt(0));

        hc.calltv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:"+ PhoneNumberUtils.formatNumber(single.getContact().toString())));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    Log.d(TAG, "onClick: clicked");
                    //context.startActivity(call);
                }
                else{
                    Log.d(TAG, "onClick: failed");
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class RcHolder extends RecyclerView.ViewHolder{
        TextView nametv2,numbertv2,imagetv2;
        Button calltv2;
        View all;

        public RcHolder(@NonNull View it) {
            super(it);
            nametv2=it.findViewById(R.id.nametv2);
            imagetv2=it.findViewById(R.id.imagetv2);
            numbertv2=it.findViewById(R.id.numbertv2);
            calltv2=it.findViewById(R.id.calltv2);
            all=it.findViewById(R.id.all);

        }
    }
}

