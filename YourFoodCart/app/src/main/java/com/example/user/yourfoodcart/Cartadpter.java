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

import java.util.List;

public class Cartadpter extends RecyclerView.Adapter<Cartadpter.CartHolder> {
    int[] img;
    String[] nameandprice;
    Context context;
    List<Integer> cart;
    public Cartadpter(int [] a, String[] b , Context c, List<Integer> cart) {
        this.img=a;
        this.nameandprice=b;
        this.context=c;
        this.cart=cart;


    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.foodcard, viewGroup, false);
        return new CartHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder rcHolder, int i) {
         int finalty=cart.get(i);
        String[] np = nameandprice[finalty].split(":");
        final String name = np[0];
        final String price = np[1];
        rcHolder.image.setImageResource(img[finalty]);
        rcHolder.name.setText(name);
        rcHolder.price.setText(price);


    }

    @Override
    public int getItemCount() {
        return cart.size() ;
    }

    class CartHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name, price;
        public CartHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.img1);
            name = itemView.findViewById(R.id.n1);
            price = itemView.findViewById(R.id.p1);
        }
    }
}
