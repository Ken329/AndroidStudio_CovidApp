package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainPreventAll extends AppCompatActivity {
    ImageButton back;
    TextView prevent1, prevent2, prevent3, prevent4, prevent5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_prevent_all);
        getSupportActionBar().hide();

        back = findViewById(R.id.mainPreventAllBack);
        prevent1 = findViewById(R.id.mainPreventAll1);
        prevent2 = findViewById(R.id.mainPreventAll2);
        prevent3 = findViewById(R.id.mainPreventAll3);
        prevent4 = findViewById(R.id.mainPreventAll4);
        prevent5 = findViewById(R.id.mainPreventAll5);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        prevent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheet bottom = new bottomSheet("mask", MainPreventAll.this);
                bottom.getBottomSheet();
            }
        });
        prevent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheet bottom = new bottomSheet("distance", MainPreventAll.this);
                bottom.getBottomSheet();
            }
        });
        prevent3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheet bottom = new bottomSheet("wash", MainPreventAll.this);
                bottom.getBottomSheet();
            }
        });
        prevent4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheet bottom = new bottomSheet("risk", MainPreventAll.this);
                bottom.getBottomSheet();
            }
        });
        prevent5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheet bottom = new bottomSheet("care", MainPreventAll.this);
                bottom.getBottomSheet();
            }
        });
    }
}