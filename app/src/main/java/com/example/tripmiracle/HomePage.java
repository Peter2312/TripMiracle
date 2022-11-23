package com.example.tripmiracle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tripmiracle.databinding.ActivityHomePageBinding;
import com.example.tripmiracle.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class HomePage extends AppCompatActivity {

    public static final String TAG = "HomePage";
    public static final String USERNAME = "com.example.tripmiracle.USERNAME";

    private ActivityHomePageBinding binding;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference adminRef = db.collection("admin").document();
    private DocumentReference userRef = db.collection("user").document();
    private CollectionReference usernameRef = db.collection("user");

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
                intent1.putExtra(BookActivity.USERNAME, binding.usernameDisplay.getText().toString());
                startActivity(intent1);
            }
        });

        binding.checkBookingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}