package com.example.user.nplay;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mtechviral.mplaylib.MusicFinder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Rcadapter extends RecyclerView.Adapter<Rcadapter.Rcholder> {

    final Context con;
    List<MusicFinder.Song> data;
    public Rcadapter(Context con,List<MusicFinder.Song> d) {
        data= new ArrayList();
        this.data=d;
        this.con = con;
    }


    @NonNull
    @Override
    public Rcadapter.Rcholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater inflater = LayoutInflater.from(con);
        View v = inflater.inflate(R.layout.cardview,viewGroup,false);
        return new Rcholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Rcadapter.Rcholder rcholder, int i) {
        final MusicFinder.Song single;
        if(rcholder!= null){
    single = data.get(i);
   rcholder.Sname.setText(single.getTitle());
   rcholder.SArtist.setText(single.getTitle());

    Picasso.with(con).load(single.getAlbumArt()).fit().centerCrop().placeholder(R.drawable.mps).into(rcholder.cardavtar);
}
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Rcholder extends RecyclerView.ViewHolder {
         ImageView cardavtar;
        TextView SArtist,Sname;

        public Rcholder(@NonNull View itemView) {
            super(itemView);
            cardavtar=itemView.findViewById(R.id.avtra);
            Sname=itemView.findViewById(R.id.name);
            SArtist=itemView.findViewById(R.id.aname);
        }
    }
}
