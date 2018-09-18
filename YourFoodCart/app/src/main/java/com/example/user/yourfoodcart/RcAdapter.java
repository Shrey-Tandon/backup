package com.example.user.yourfoodcart;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RcAdapter extends RecyclerView.Adapter<RcAdapter.RcHolder> {
    int[] img;
    String[] nameandprice;
    Context context;
    public RcAdapter(int [] a, String[] b , Context c) {
        this.img=a;
        this.nameandprice=b;
        this.context=c;


    }
    @NonNull
    @Override
    public RcHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.foodcard, viewGroup, false);
        return new RcHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RcAdapter.RcHolder rcHolder, final int i) {
        String[] np = nameandprice[i].split(":");
        final String name = np[0];
        final String price = np[1];
        rcHolder.image.setImageResource(img[i]);
        rcHolder.name.setText(name);
        rcHolder.price.setText(price+" Rs/-");

        rcHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main5Activity.class);
                intent.putExtra("item", i);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    class RcHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, price;

        public RcHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.img1);
            name = itemView.findViewById(R.id.n1);
            price = itemView.findViewById(R.id.p1);

        }

    }
}