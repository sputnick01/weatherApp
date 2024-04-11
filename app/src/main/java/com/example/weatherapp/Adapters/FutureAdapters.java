package com.example.weatherapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherapp.Domains.FutureDomain;
import com.example.weatherapp.R;

import java.util.ArrayList;

public class FutureAdapters extends RecyclerView.Adapter<FutureAdapters.viewHolder> {



    ArrayList<FutureDomain> items;
    Context context;
    public FutureAdapters(ArrayList<FutureDomain> items) {
        this.items = items;
    }
    @NonNull
    @Override
    public FutureAdapters.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_future,parent,false);
        context=parent.getContext();
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FutureAdapters.viewHolder holder, int position) {
     holder.dayTxt.setText(items.get(position).getDay());
     holder.statusTxt.setText(items.get(position).getStatus());
     holder.highTxt.setText(items.get(position).getHighTemp()+"");
     holder.lowTxt.setText(items.get(position).getLowTemp()+"");


    int drawableResourceId=
            holder.itemView.getResources().getIdentifier(items.get(position).getPicPath()
                    ,"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context).load(drawableResourceId).into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView dayTxt,statusTxt,lowTxt,highTxt;
        ImageView pic;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            dayTxt=itemView.findViewById(R.id.txtDay);
            statusTxt=itemView.findViewById(R.id.txtStatus);
            lowTxt=itemView.findViewById(R.id.txtlow);
            highTxt=itemView.findViewById(R.id.txthigh);
            pic=itemView.findViewById(R.id.imgFuture);

        }
    }
}
