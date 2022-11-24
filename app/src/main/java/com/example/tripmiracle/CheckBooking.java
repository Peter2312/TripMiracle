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
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class CheckBooking extends AppCompatActivity {

    private static final String TAG = "CheckBooking";

    private ActivityCheckBookingBinding binding;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference bookings = db.collection("booking").document();
    private CollectionReference bookingList = db.collection("booking");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_booking);

        binding = ActivityCheckBookingBinding.inflate(getLayoutInflater());
        LinearLayout view = binding.getRoot();
        setContentView(view);

        Query query = bookingList.orderBy("time", Query.Direction.DESCENDING).limit(1);
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        binding.usernameCheckBooking.setText(document.getString("name"));
                        binding.roomCheckBooking.setText(document.getLong("room").toString());
                        binding.dateCheckBooking.setText(document.getString("date"));
                        binding.durationCheckBooking.setText(document.getString("duration"));
                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }

                /*binding.usernameCheckBooking.setText();
                binding.roomCheckBooking.setText();
                binding.dateCheckBooking.setText();
                binding.durationCheckBooking.setText();*/
            }
        });
    }
}