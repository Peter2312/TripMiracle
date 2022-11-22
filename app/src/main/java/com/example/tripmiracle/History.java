package com.example.tripmiracle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.tripmiracle.databinding.ActivityHomePageBinding;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    private ActivityHomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ArrayList<Booking> booking = new ArrayList<>();
        Booking booking1 = new Booking(1000, "3 hours", "3/4/2022");
        Booking booking2 = new Booking(2000, "48 hours", "1/1/2022");
        booking.add(booking1);
        booking.add(booking2);

        RecyclerView recyclerView = findViewById(R.id.historyRecyclerView);
        HistoryAdapter adapter = new HistoryAdapter(this,booking);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        LinearLayout view = binding.getRoot();
        setContentView(view);

        binding.bookHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(History.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
