/*
 * Copyright (c) 2020. Tekminds Limited
 * @Author: Vishwanath Hariharan
 * vishi83@gmail.com
 */
package com.tekminds.firebaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class EventGalleryActivity extends AppCompatActivity {

    private static final String TAG = "ClassesActivity";
    private TextView eventName;
    private TextView eventDesc;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_event_with_details);

        eventName = findViewById(R.id.classTitle);
        eventDesc = findViewById(R.id.classDesc);
        imageView = findViewById(R.id.classImg);

        final Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        eventName.setText(intent.getExtras().getString("name"));
        eventDesc.setText(intent.getExtras().getString("description"));

        Glide.with(this)
                .load(intent.getExtras().getString("imageUrl"))
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .into(imageView);
    }
}
