package com.example.covidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainUpdate extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    ImageButton back;
    Spinner spinner;
    EditText cases, death, recovered, icu, treatment;
    TextView tCases, tDeath, tRecovered, tIcu, tTreatment;
    TextView enter;

    DatabaseReference ref;
    String country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_update);
        getSupportActionBar().hide();

        back = findViewById(R.id.updateBack);
        spinner = findViewById(R.id.updateSpinner);
        cases = findViewById(R.id.updateCases);
        death = findViewById(R.id.updateDeath);
        recovered = findViewById(R.id.updateRecovered);
        icu = findViewById(R.id.updateIcu);
        treatment = findViewById(R.id.updateTreatment);
        tCases = findViewById(R.id.updateTotalCases);
        tDeath = findViewById(R.id.updateTotalDeath);
        tRecovered = findViewById(R.id.updateTotalRecovered);
        tIcu = findViewById(R.id.updateTotalIcu);
        tTreatment = findViewById(R.id.updateTotalTreatment);
        enter = findViewById(R.id.updateEnter);

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
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myCases = cases.getText().toString();
                String myDeath = death.getText().toString();
                String myRecovered = recovered.getText().toString();
                String myIcu = icu.getText().toString();
                String myTreatment = treatment.getText().toString();
                today t1 = new today(myCases, myDeath, myRecovered, myIcu, myTreatment);
                ref = FirebaseDatabase.getInstance().getReference("today").child(country);
                ref.setValue(t1);
                updateCases(country, myCases, myDeath, myRecovered, myIcu, myTreatment);
                Toast.makeText(MainUpdate.this, "Successful update cases", Toast.LENGTH_LONG).show();
                cases.setText("");
                death.setText("");
                recovered.setText("");
                icu.setText("");
                treatment.setText("");
            }
        });
    }
    public void updateCases(String country, String cases, String death, String recover, String icu, String treatment){
        ref = FirebaseDatabase.getInstance().getReference("total").child(country);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String sCases = snapshot.child("total_cases").getValue().toString();
                String sDeath = snapshot.child("total_death").getValue().toString();
                String sRecover = snapshot.child("total_recovered").getValue().toString();
                String sIcu = snapshot.child("total_icu").getValue().toString();
                String sTreatment = snapshot.child("total_treatment").getValue().toString();

                int totalCases = Integer.parseInt(cases) + Integer.parseInt(sCases);
                int totalDeath = Integer.parseInt(death) + Integer.parseInt(sDeath);
                int totalRecover = Integer.parseInt(recover) + Integer.parseInt(sRecover);
                int totalIcu = Integer.parseInt(icu) + Integer.parseInt(sIcu);
                int totalTreatment = Integer.parseInt(sTreatment) + Integer.parseInt(treatment);

                total t1 = new total(String.valueOf(totalCases), String.valueOf(totalDeath), String.valueOf(totalRecover),
                        String.valueOf(totalIcu), String.valueOf(totalTreatment));
                ref.setValue(t1);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void insertCases(String country){
        ref = FirebaseDatabase.getInstance().getReference("total").child(country);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tCases.setText(snapshot.child("total_cases").getValue().toString());
                tDeath.setText(snapshot.child("total_death").getValue().toString());
                tRecovered.setText(snapshot.child("total_recovered").getValue().toString());
                tIcu.setText(snapshot.child("total_icu").getValue().toString());
                tTreatment.setText(snapshot.child("total_treatment").getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        country = parent.getItemAtPosition(position).toString();
        insertCases(country);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}