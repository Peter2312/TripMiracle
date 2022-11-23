package com.example.tripmiracle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

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
                DocumentSnapshot document = task.getResult();
                if (document != null) {

                } else {
                    Log.d(TAG, "No such document");
                }
            }
        });
    }
}