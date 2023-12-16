package com.example.minichat.LoginActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spanned;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.minichat.R;

public class TitleActivity extends AppCompatActivity {

    Button regToBtn;
    TextView signInTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        regToBtn = findViewById(R.id.register_to_button);
        signInTo = findViewById(R.id.sign_in_to_textview);

        String htmlTaggedString = String.format("<u>%s</u>", String.valueOf(signInTo.getText()));
        Spanned textSpan = android.text.Html.fromHtml(htmlTaggedString);
        signInTo.setText(textSpan);

        regToBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signInTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signInTo.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                return false;
            }
        });
    }
}