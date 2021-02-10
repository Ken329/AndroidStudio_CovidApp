package com.example.covidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    ImageButton sideMenu;
    TextView cases, phone, sms, showMore, statistic;
    ImageView flag;
    Spinner spinner;
    DrawerLayout drawerLayout;
    NavigationView sideLayout;

    Intent intent;
    DatabaseReference ref;
    String myCountry;
    private AlertDialog dialog;
    private  AlertDialog.Builder dialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        sideMenu = findViewById(R.id.mainSideMenu);
        drawerLayout = findViewById(R.id.mainDrawer);
        sideLayout = findViewById(R.id.mainNav);
        flag = findViewById(R.id.mainFlag);
        spinner = findViewById(R.id.mainSpinner);
        cases = findViewById(R.id.mainCases);
        phone = findViewById(R.id.mainPhone);
        sms = findViewById(R.id.mainSms);
        showMore = findViewById(R.id.mainShowMore);
        statistic = findViewById(R.id.mainStatistic);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        sideMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        sideLayout.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_item1:
                        buildDialog();
                        return true;
                    case R.id.menu_item2:
                        Toast.makeText(MainActivity.this, "About Us", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_item3:
                        Toast.makeText(MainActivity.this, "Contact", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_item4:
                        Toast.makeText(MainActivity.this, "Help Center", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_item5:
                        Toast.makeText(MainActivity.this, "Quit", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
        showMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMore(myCountry);
            }
        });
        statistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMore(myCountry);
            }
        });
    }
    public void buildDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View view = getLayoutInflater().inflate(R.layout.update_popup, null);
        TextView pass = (TextView) view.findViewById(R.id.popUpPassword);
        TextView enter = (TextView) view.findViewById(R.id.popUpEnter);

        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = pass.getText().toString();
                if(password.equals("Admin")){
                    intent = new Intent(getApplicationContext(), MainUpdate.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Wrong password !!!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
    }
    public void showMore(String country){
        Intent intent = new Intent(getApplicationContext(), MainShowCases.class);
        intent.putExtra("country", country);
        startActivity(intent);
    }
    public void updateCases(String country){
        ref = FirebaseDatabase.getInstance().getReference("total").child(country);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                cases.setText(snapshot.child("total_cases").getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        myCountry = parent.getItemAtPosition(position).toString();
        switch (myCountry){
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
        updateCases(myCountry);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}