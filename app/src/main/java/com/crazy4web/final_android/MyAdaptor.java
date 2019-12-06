package com.crazy4web.final_android;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyViewHolder> {

    ArrayList<String> redditlist = new ArrayList<>();
    Context mcon;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        LinearLayout linearLayout;

        public MyViewHolder(View v) {

            super(v);
            textView = v.findViewById(R.id.textView);
            linearLayout = v.findViewById(R.id.linearlayout);
        }
    }


    public MyAdaptor(Context context,ArrayList redditlist) {

        this.redditlist = redditlist;
        mcon = context;

    }






    @Override
    public MyAdaptor.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerrow, parent, false);



        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {


        holder.textView.setText(redditlist.get(position));

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(mcon, newslistreddit.class);
                i.putExtra("textname",redditlist.get(position));
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcon.startActivity(i);
            }
        });
    }


    public int getItemCount() {
        return redditlist.size();
    }
}
