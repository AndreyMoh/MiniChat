package com.example.minichat.LoginActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.minichat.Classes.User;
import com.example.minichat.MainActivity;
import com.example.minichat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText emailView, passwordView, firstNameView, lastNameView, usernameView;
    Button regBtn;
    TextView loginToBtn;
    ProgressBar progressBar;
    FirebaseAuth mAuth;
    FirebaseDatabase db;
    DatabaseReference reference;

    String first_name, last_name, username;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        emailView = findViewById(R.id.email_editText);
        passwordView = findViewById(R.id.password_editText);
        firstNameView = findViewById(R.id.first_name_editText);
        lastNameView = findViewById(R.id.last_name_editText);
        usernameView = findViewById(R.id.username_editText);
        regBtn = findViewById(R.id.register_btn);
        loginToBtn = findViewById(R.id.sign_in_to_textview);
        progressBar = findViewById(R.id.progressBar);

        String htmlTaggedString = String.format("<u>%s</u>", String.valueOf(loginToBtn.getText()));
        Spanned textSpan = android.text.Html.fromHtml(htmlTaggedString);
        loginToBtn.setText(textSpan);

        loginToBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                String email, password;
                email = String.valueOf(emailView.getText()).trim();
                password = String.valueOf(passwordView.getText()).trim();

//                if (TextUtils.isEmpty(email)) {
//                    Toast.makeText(RegisterActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if (TextUtils.isEmpty(password)) {
//                    Toast.makeText(RegisterActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                {
                    first_name = String.valueOf(firstNameView.getText());
                    last_name = String.valueOf(lastNameView.getText());
                    username = String.valueOf(usernameView.getText());
                }
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(RegisterActivity.this, "Enter username", Toast.LENGTH_SHORT).show();
                    return;
                }
//                mAuth.createUserWithEmailAndPassword(email, password)
//                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                progressBar.setVisibility(View.GONE);
//
//                                if (task.isSuccessful()) {
//                                    Toast.makeText(RegisterActivity.this, "Authentication success", Toast.LENGTH_SHORT).show();
//
//                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
//                finish();
//                                } else {
//                                    // If sign in fails, display a message to the user.
//                                    Toast.makeText(RegisterActivity.this, "Authentication failed.",
//                                            Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
                setData();
            }
        });
    }
    private void setData() {
        User user = new User(first_name, last_name, username);
        reference = FirebaseDatabase.getInstance().getReference("Users");
        Toast.makeText(RegisterActivity.this, reference.toString(), Toast.LENGTH_SHORT).show();
        FirebaseUser usser = mAuth.getCurrentUser();
        String id = null;
        if (usser != null) {
            id = usser.getUid();
        }
        reference.child(username).setValue("user").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(RegisterActivity.this, "data attached", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this, "data didn't attached", Toast.LENGTH_SHORT).show();
            }
        });
    }
}