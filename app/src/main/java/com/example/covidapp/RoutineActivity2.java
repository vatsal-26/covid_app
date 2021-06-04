package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RoutineActivity2 extends AppCompatActivity {

    ImageView back;
    Button vaccinate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine2);

        back = findViewById(R.id.imageView8);
        vaccinate = findViewById(R.id.button9);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(RoutineActivity2.this, HomeActivity2.class);
                startActivity(i);
                finish();

            }
        });

        vaccinate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://selfregistration.cowin.gov.in/"));
                startActivity(browserIntent);
                finish();
            }
        });

    }
}