package com.example.tripmiracle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.tripmiracle.databinding.ActivityHomePageBinding;

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

        binding.booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, BookActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.checkBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, CheckBooking.class);
                startActivity(intent);
                finish();
            }
        });

        binding.bookHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, History.class);
                startActivity(intent);
                finish();
            }
        });
    }
}