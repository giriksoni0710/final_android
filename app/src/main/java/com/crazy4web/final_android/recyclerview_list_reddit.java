package com.crazy4web.final_android;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerview_list_reddit extends RecyclerView.Adapter<recyclerview_list_reddit.MyViewHolder> {

    ArrayList<String> redditlist = new ArrayList<>();
    Context mcon;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        LinearLayout linearLayout;

        public MyViewHolder(View v) {

            super(v);
            textView = v.findViewById(R.id.redit_text_row);
        }
    }


    public recyclerview_list_reddit(ArrayList redditlist) {

        this.redditlist = redditlist;

    }






    @Override
    public recyclerview_list_reddit.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.newsrow, parent, false);



        recyclerview_list_reddit.MyViewHolder vh = new recyclerview_list_reddit.MyViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull final recyclerview_list_reddit.MyViewHolder holder, final int position) {


        holder.textView.setText(redditlist.get(position));

    }


    public int getItemCount() {
        return redditlist.size();
    }
}
