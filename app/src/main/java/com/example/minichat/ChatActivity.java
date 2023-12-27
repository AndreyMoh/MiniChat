package com.example.minichat;

import android.content.Intent;
import android.os.Bundle;
import android.text.NoCopySpan;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.minichat.Classes.ChatMiniature;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatActivity extends AppCompatActivity {

    ImageButton backBtn, sentMsgBtn;
    EditText wrtLineTxt;
    ChatMiniature info;

    FirebaseDatabase db;
    DatabaseReference ref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_view);

        db = FirebaseDatabase.getInstance();
        ref = db.getReference();

        backBtn = findViewById(R.id.back_to_main);
        sentMsgBtn = findViewById(R.id.sent_message_button);
        wrtLineTxt = findViewById(R.id.writing_line_edt);

        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            info = (ChatMiniature) arguments.getSerializable(ChatMiniature.class.getSimpleName());
        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        sentMsgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(String.valueOf(wrtLineTxt.getText()).trim())) return;
                ref.child(info.getUsername()).setValue(String.valueOf(wrtLineTxt.getText()));
                Toast.makeText(ChatActivity.this, wrtLineTxt.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
