/*
 * Copyright (c) 2020. Tekminds Limited
 * @Author: Vishwanath Hariharan
 * vishi83@gmail.com
 */

package com.tekminds.firebaseapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private EditText email;
    private EditText password;
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    private List<Map<String, Object>> activityList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.fieldEmail);
        password = findViewById(R.id.fieldPassword);

        // sign in button
        findViewById(R.id.signIn).setOnClickListener(this);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,
                DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(linearLayoutManager);

        // initialize firebase auth...
        mAuth = FirebaseAuth.getInstance();
        // firebase firestore instance
        firestore = FirebaseFirestore.getInstance();

        // FIXME: avoid during device orientation..
        FirebaseInstanceId.getInstance().getInstanceId()
            .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                @Override
                public void onComplete(@NonNull Task<InstanceIdResult> task) {
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "getInstanceId failed", task.getException());
                        return;
                    }
                    // Get new Instance ID token
                    String token = task.getResult().getToken();
                    // Log and toast
                    String msg = getString(R.string.msg_token_fmt, token);
                    Log.i(TAG, msg);
                }
            });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            findViewById(R.id.fieldEmail).setVisibility(View.GONE);
            findViewById(R.id.fieldPassword).setVisibility(View.GONE);
            findViewById(R.id.signIn).setVisibility(View.GONE);
            // listen to firstore data changes...
            getDataFromStore();
        } else {
            findViewById(R.id.fieldEmail).setVisibility(View.VISIBLE);
            findViewById(R.id.fieldPassword).setVisibility(View.VISIBLE);
            findViewById(R.id.signIn).setVisibility(View.VISIBLE);
        }
    }

    private void renderListView(List<Map<String, Object>> activityList) {
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, activityList);
        recyclerView.setAdapter(myAdapter);
    }

    private void getDataFromStore() {
        firestore.collection(getString(R.string.firestore_collection)).orderBy("timestamp", Query.Direction.DESCENDING)
            .addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value,
                                    @Nullable FirebaseFirestoreException e) {
                    if (e != null) {
                        Log.w(TAG, "Listen failed.", e);
                        return;
                    }
                    activityList = new ArrayList<Map<String, Object>>();
                    for (QueryDocumentSnapshot doc : value) {
                        Log.d(TAG, "document : " + doc.getData().toString());
                        activityList.add(doc.getData());
                    }
                    renderListView(activityList);
                }
            });
    }

    private void signIn(String email, String password) {
        Log.i(TAG, "Sign in using email: " + email);
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    showToast("Logged In Successfully!");
                    updateUI(user);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                    showToast("Login Failed!");
                    updateUI(null);
                }
                }
            });
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Log out");
        builder.setMessage("Are you sure you want to log out?");
        builder.setCancelable(true);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do logout
                mAuth.signOut();
                MainActivity.super.onBackPressed();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Add any logic if required..
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.signIn) {
            signIn(email.getText().toString(), password.getText().toString());
        }
    }
}
