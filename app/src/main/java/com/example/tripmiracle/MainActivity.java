package com.example.tripmiracle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.tripmiracle.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    EditText textInputUsername, textInputPassword;
    private FirebaseAuth mAuth;

    //declare elements
    //inflate activity_main layout to access elements easier
    //LayoutInflater l = getLayoutInflater();
    //View v = l.inflate(R.layout.activity_main, null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputUsername = findViewById(R.id.usernameLogin);
        textInputPassword = findViewById(R.id.passwordLogin);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username, password;
                username = String.valueOf(textInputUsername.getText());
                password = String.valueOf(textInputPassword.getText());

                if(true) {
                    Intent i = new Intent(getApplicationContext(), HomePage.class);
                    getIntent().putExtra("username", username);
                    startActivity(i);
                }
            }
        });



    }
}