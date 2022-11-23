package com.example.tripmiracle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.tripmiracle.databinding.ActivityHomePageBinding;
import com.example.tripmiracle.databinding.ActivityMainBinding;

public class HomePage extends AppCompatActivity {

    public static final String USERNAME = "com.example.tripmiracle.USERNAME";

    private ActivityHomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        LinearLayout view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        binding.usernameDisplay.setText(intent.getStringExtra(USERNAME));

        binding.booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(HomePage.this, BookActivity.class);
                startActivity(intent1);
            }
        });
    }
}