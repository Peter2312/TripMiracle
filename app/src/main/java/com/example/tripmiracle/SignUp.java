package com.example.tripmiracle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tripmiracle.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity{

    private ActivitySignUpBinding binding;
    EditText signupInputUsername, signupInputPassword, signupInputPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupInputUsername = findViewById(R.id.signup_username);
        signupInputPassword = findViewById(R.id.signup_password);
        signupInputPasswordConfirm = findViewById(R.id.signup_password_confirm);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        binding.signUpConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username, password, passwordConfirm;
                username = String.valueOf(signupInputUsername.getText());
                password = String.valueOf(signupInputPassword.getText());
                passwordConfirm = String.valueOf(signupInputPasswordConfirm.getText());

                if(!username.equals("") && !password.equals("") && !passwordConfirm.equals("")) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if(password.equals(passwordConfirm)) {
                                //check duplicate username in database
                                if(true) { //no duplicate
                                    //add user
                                    Toast.makeText(getApplicationContext(), "Account successfully created.", Toast.LENGTH_SHORT).show();
                                }
                                else { //duplicate
                                    Toast.makeText(getApplicationContext(), "Username already used.", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Passwords must match.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(), "All fields must be filled.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
