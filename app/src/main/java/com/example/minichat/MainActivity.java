package com.example.minichat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.example.minichat.Adapters.ChatMiniatureAdapter;
import com.example.minichat.Classes.ChatMiniature;
import com.example.minichat.Fragments.MainFragment;
import com.example.minichat.Fragments.SettingsFragment;
import com.example.minichat.LoginActivities.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    List<ChatMiniature> miniatures = new ArrayList<ChatMiniature>();
    FirebaseAuth mAuth;
    FirebaseUser user;
    ImageButton add_btn;
    CardView acc_btn, chats_btn, settings_btn;
    FrameLayout main_layout;
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

        add_btn = findViewById(R.id.add_button);
        acc_btn = findViewById(R.id.acc_btn);
        chats_btn = findViewById(R.id.chats_btn);
        settings_btn = findViewById(R.id.settings_btn);
        main_layout = findViewById(R.id.main_layout);

        add_btn.setOnClickListener(this);
        acc_btn.setOnClickListener(this);
        chats_btn.setOnClickListener(this);
        settings_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.add_button) {
            // nothing
        } else if (id == R.id.acc_btn) {
            // frame
        } else if (id == R.id.chats_btn) {
            selectFragment(new MainFragment());
        } else if (id == R.id.settings_btn) {
            selectFragment(new SettingsFragment());
        }
    }

    private void selectFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_layout, fragment);
        fragmentTransaction.commit();
    }
}