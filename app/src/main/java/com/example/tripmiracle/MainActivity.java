package com.example.tripmiracle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //declare elements
    //inflate activity_main layout to access elements easier
    LayoutInflater l = getLayoutInflater();
    View v = l.inflate(R.layout.activity_main, null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}