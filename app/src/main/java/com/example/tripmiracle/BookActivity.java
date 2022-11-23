package com.example.tripmiracle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tripmiracle.databinding.ActivityBookBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class BookActivity extends AppCompatActivity {

    private ActivityBookBinding binding;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference bookings = db.collection("booking").document();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        binding = ActivityBookBinding.inflate(getLayoutInflater());
        LinearLayout view = binding.getRoot();
        setContentView(view);

        binding.bookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Booking booking = new Booking();
                bookings.set(booking).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(BookActivity.this, "Booking Successful", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}