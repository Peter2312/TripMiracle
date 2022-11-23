package com.example.tripmiracle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tripmiracle.databinding.ActivityCheckBookingBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class CheckBooking extends AppCompatActivity {

    private static final String TAG = "CheckBooking";

    private ActivityCheckBookingBinding binding;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference bookings = db.collection("booking").document();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_booking);

        binding = ActivityCheckBookingBinding.inflate(getLayoutInflater());
        LinearLayout view = binding.getRoot();
        setContentView(view);

        bookings.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null) {
                        binding.roomCheckBooking.setText(document.getLong("roomNo").intValue());
                    } else {
                        Log.d(TAG, "No such document");
                        Toast.makeText(CheckBooking.this, "No such document", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.w(TAG, "unable to retrieve document", task.getException());
                }
            }
        });
    }
}