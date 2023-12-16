package com.example.minichat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.minichat.Adapters.ChatMiniatureAdapter;
import com.example.minichat.Classes.ChatMiniature;
import com.example.minichat.LoginActivities.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ChatMiniature> miniatures = new ArrayList<ChatMiniature>();
    FirebaseAuth mAuth;
    FirebaseUser user;
    String username;
    Button signOutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            username = user.getEmail();
        }

        RecyclerView lMiniatures = findViewById(R.id.MiniaturesRecyclerView);
        signOutBtn = findViewById(R.id.sign_out_button);

        miniatures.add(new ChatMiniature(null, "Mom", "GoodBye!", "12.12.2023"));
        miniatures.add(new ChatMiniature(null, "Dad", "Take some beer", "11.12.2023"));
        miniatures.add(new ChatMiniature(null, "Sister", "Turn off music!!!", "Now"));
        miniatures.add(new ChatMiniature(null, "Jessica", "Come to me", "Now"));

        lMiniatures.setLayoutManager(new LinearLayoutManager(this));
        lMiniatures.setAdapter(new ChatMiniatureAdapter(getApplicationContext(), miniatures));

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}