package com.example.user.vplay;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mtechviral.mplaylib.MusicFinder;

import java.util.ArrayList;
import java.util.List;

public class Recycler_adapter extends RecyclerView.Adapter<Recycler_adapter.Recycling>{
    final Context con;
    List<MusicFinder.Song>data;
    public Recycler_adapter(Context con, List<MusicFinder.Song> d ) {
        this.con = con;
        data=new ArrayList();
        this.data=d;
    }

    @NonNull
    @Override
    public Recycling onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(con);
        View v=inflater.inflate(R.layout.cards,viewGroup,false);
        return new Recycling(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycling recycling, int i) {

        final MusicFinder.Song single;
        if (recycling!=null){
            single=data.get(i);
            recycling.Sname.setText(single.getTitle());
            recycling.Sartist.setText(single.getArtist());

            recycling.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

    }

    @Override
    public int getItemCount() {

        return data.size();
    }



    public class Recycling extends RecyclerView.ViewHolder {
        TextView Sname,Sartist;
        ImageView cardavtar;

       public Recycling(@NonNull View itemView) {
           super(itemView);
           cardavtar=itemView.findViewById(R.id.avtar);
           Sname=itemView.findViewById(R.id.Sname);
           Sartist=itemView.findViewById(R.id.Sartist);
       }
   }



}
