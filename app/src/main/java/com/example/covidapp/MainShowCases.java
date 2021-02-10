package com.example.covidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainShowCases extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ImageButton back;
    ImageView flag;
    Spinner spinner;
    TextView tCases, tDeath, tRecovered, tTreatment, tIcu, dCases, dDeath, dRecovered, dTreatment, dIcu, seeAll;

    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_show_cases);
        getSupportActionBar().hide();

        back = findViewById(R.id.showMoreBack);
        flag = findViewById(R.id.showMoreFlag);
        spinner = findViewById(R.id.showMoreSpinner);
        tCases = findViewById(R.id.showMoreTCases);
        tDeath = findViewById(R.id.showMoreTDeath);
        tRecovered = findViewById(R.id.showMoreTRecovered);
        tTreatment = findViewById(R.id.showMoreTTreatment);
        tIcu = findViewById(R.id.showMoreTIcu);
        dCases = findViewById(R.id.showMoreDCases);
        dDeath = findViewById(R.id.showMoreDDeath);
        dRecovered = findViewById(R.id.showMoreDRecovered);
        dTreatment = findViewById(R.id.showMoreDTreatment);
        dIcu = findViewById(R.id.showMoreDIcu);
        seeAll = findViewById(R.id.showMoreSeeAll);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainShowCases.this, "Sorry, function not available yet!!!", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void updateTotalCases(String country){
        ref = FirebaseDatabase.getInstance().getReference("total").child(country);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tCases.setText(snapshot.child("total_cases").getValue().toString());
                tDeath.setText(snapshot.child("total_death").getValue().toString());
                tRecovered.setText(snapshot.child("total_recovered").getValue().toString());
                tTreatment.setText(snapshot.child("total_treatment").getValue().toString());
                tIcu.setText(snapshot.child("total_icu").getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void updateTodayCases(String country){
        ref = FirebaseDatabase.getInstance().getReference("today").child(country);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dCases.setText(snapshot.child("today_cases").getValue().toString());
                dDeath.setText(snapshot.child("today_death").getValue().toString());
                dRecovered.setText(snapshot.child("today_recovered").getValue().toString());
                dTreatment.setText(snapshot.child("today_treatment").getValue().toString());
                dIcu.setText(snapshot.child("today_icu").getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String country = parent.getItemAtPosition(position).toString();
        switch (country){
            case "Australia":
                flag.setImageResource(R.mipmap.australia_foreground);
                break;
            case "United State":
                flag.setImageResource(R.mipmap.us_foreground);
                break;
            case "Cambodia":
                flag.setImageResource(R.mipmap.cambodia_foreground);
                break;
            case "France":
                flag.setImageResource(R.mipmap.france_foreground);
                break;
            case "Italy":
                flag.setImageResource(R.mipmap.italy_foreground);
                break;
            case "Korea":
                flag.setImageResource(R.mipmap.korea_foreground);
                break;
            case "Malaysia":
                flag.setImageResource(R.mipmap.malaysia_foreground);
                break;
            case "Thailand":
                flag.setImageResource(R.mipmap.thailand_foreground);
                break;
            case "Bangladesh":
                flag.setImageResource(R.mipmap.bangladesh_foreground);
                break;
            case "New Zealand":
                flag.setImageResource(R.mipmap.new_zealand_foreground);
                break;
            case "Pakistan":
                flag.setImageResource(R.mipmap.pakistan_foreground);
                break;
            case "Singapore":
                flag.setImageResource(R.mipmap.singapore_foreground);
                break;
            case "Belgium":
                flag.setImageResource(R.mipmap.belgium_foreground);
                break;
            case "Hungary":
                flag.setImageResource(R.mipmap.hungary_foreground);
                break;
        }
        updateTotalCases(country);
        updateTodayCases(country);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}