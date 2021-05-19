package com.example.covidapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Trace;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity2 extends AppCompatActivity {
    Button btnLogOut;
    Button statis;
    Button call;
    Button diab, blood, other;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    Button route;
    Button vaccine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        call = (Button)findViewById(R.id.button);
        statis = (Button)findViewById(R.id.button2);
        diab = (Button)findViewById(R.id.button9);
        blood = (Button)findViewById(R.id.button8);
        other = (Button)findViewById(R.id.button10);
        statis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent statist = new Intent(HomeActivity2.this, Statistics.class);
                startActivity(statist);

            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:1916");
                Intent i = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(i);
            }
        });

        route = (Button)findViewById(R.id.rout);
        route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent routine = new Intent(HomeActivity2.this, RoutineActivity2.class);
                startActivity(routine);

            }
        });



        diab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent routine = new Intent(HomeActivity2.this, diabetes.class);
                startActivity(routine);

            }
        });

        blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent routine = new Intent(HomeActivity2.this, bloodpressure.class);
                startActivity(routine);

            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent routine = new Intent(HomeActivity2.this, others.class);
                startActivity(routine);

            }
        });

//        spinner = (Spinner) findViewById(R.id.spin1);
//        adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);

//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " Selected", Toast.LENGTH_LONG).show();
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        btnLogOut = findViewById(R.id.button6);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(HomeActivity2.this, MainActivity.class);
                startActivity(intToMain);
            }
        });

    }
}