package com.example.minichat;

import android.content.Intent;
import android.os.Bundle;
import android.text.NoCopySpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.minichat.Classes.ChatMiniature;

public class ChatActivity extends AppCompatActivity {

    Button backBtn;
    TextView username;
    ChatMiniature info;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_view);

        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            info = (ChatMiniature) arguments.getSerializable(ChatMiniature.class.getSimpleName());
        }

        backBtn = findViewById(R.id.back_to_main);
        username = findViewById(R.id.username);

        username.setText(info.getUsername());

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
