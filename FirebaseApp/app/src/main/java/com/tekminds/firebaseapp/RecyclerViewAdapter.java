/*
 * Copyright (c) 2020. Tekminds Limited
 * @Author: Vishwanath Hariharan
 * vishi83@gmail.com
 */
package com.tekminds.firebaseapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    private Context mContext;
    private List<Map<String, Object>> activityList;

    public RecyclerViewAdapter(Context context, List<Map<String, Object>> data) {
        this.mContext = context;
        this.activityList = data;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.recycler_view_item,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, final int position) {
        holder.eventIcon.setText(activityList.get(position).get("photo_title").toString().substring(0, 1).toUpperCase());
        holder.eventName.setText(activityList.get(position).get("photo_title").toString());
        holder.eventDesc.setText(activityList.get(position).get("photo_desc").toString());

        //setting client side date to events FIXME: later change to server date
        String date_n = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
        holder.eventTime.setText(date_n);
        // Use of Glide - image loading and caching library for firebase
        /*Glide.with(mContext)
                .load(activityList.get(position).get("thumbnail").toString())
                .centerCrop()
                .placeholder(R.drawable.skoolview)
                .into(holder.eventThumbnail);*/

        holder.eventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, EventGalleryActivity.class);
                // passing data to the classes activity
                intent.putExtra("name",activityList.get(position).get("photo_title").toString());
                intent.putExtra("description",activityList.get(position).get("photo_desc").toString());
                intent.putExtra("imageUrl", activityList.get(position).get("photo_url").toString());
                // start the activity
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return activityList.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView eventIcon;
        TextView eventDesc;
        TextView eventName;
        TextView eventTime;
        RelativeLayout eventLayout;

        public CustomViewHolder(View itemView) {
            super(itemView);

            eventIcon = (TextView) itemView.findViewById(R.id.eventIcon);
            eventName = (TextView) itemView.findViewById(R.id.eventName);
            eventDesc = (TextView) itemView.findViewById(R.id.eventDesc);
            eventTime = (TextView) itemView.findViewById(R.id.eventTime);
            eventLayout = itemView.findViewById(R.id.layout);
        }
    }
}
