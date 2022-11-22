package com.example.tripmiracle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;

import com.example.tripmiracle.databinding.ActivityBookBinding;
import com.example.tripmiracle.databinding.ActivityHomePageBinding;

import java.util.Calendar;
import java.util.TimeZone;

public class BookActivity extends AppCompatActivity {

    private ActivityBookBinding binding;
    DatePickerDialog pickerDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        binding = ActivityBookBinding.inflate(getLayoutInflater());
        LinearLayout view = binding.getRoot();
        setContentView(view);

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
                Intent intent = new Intent(BookActivity.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });

        binding.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}