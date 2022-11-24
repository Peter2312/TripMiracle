package com.example.tripmiracle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tripmiracle.databinding.ActivityBookBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class BookActivity extends AppCompatActivity {

    private static final String TAG = "BookActivity";
    public static final String USERNAME = "com.example.tripmiracle.USERNAME";

    private ActivityBookBinding binding;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference bookings = db.collection("booking");
    DatePickerDialog pickerDate;
    Random rand = new Random(); //instance of random class
    int upperbound = 999;
    int int_random = rand.nextInt(upperbound);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        binding = ActivityBookBinding.inflate(getLayoutInflater());
        LinearLayout view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        binding.usernameBooking.setText(intent.getStringExtra(USERNAME));

        binding.selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                calendar.setTimeZone(TimeZone.getTimeZone("Asia/Kuala_Lumpur"));
                int chosenDay = calendar.get(Calendar.DAY_OF_MONTH);
                int chosenMonth = calendar.get(Calendar.MONTH);
                int chosenYear = calendar.get(Calendar.YEAR);

                //DatePicker dialog
                pickerDate = new DatePickerDialog(BookActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                      binding.displayDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, chosenYear, chosenMonth, chosenDay);

                pickerDate.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                pickerDate.show();
            }
        });

        binding.returnHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy '  ' HH:mm:ss");

        String currentDateAndTime = sdf.format(new Date());

        binding.bookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Booking booking = new Booking(intent.getStringExtra(USERNAME), binding.displayDate.getText().toString(),
                        binding.durationBooking.getText().toString()+" "+binding.nights.getText().toString(), int_random, currentDateAndTime);
                bookings.document(currentDateAndTime).set(booking).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(BookActivity.this, "Booking Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.w(TAG, "unable to display", task.getException());
                        }
                    }
                });
            }
        });
    }
}