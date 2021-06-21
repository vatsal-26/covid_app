package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class RoutineActivity2 extends AppCompatActivity {

    ImageView back;
    Button vaccinate;
    RecyclerView recyclerView;
    List<Versions> versionsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine2);

        back = findViewById(R.id.imageView8);
        recyclerView = findViewById(R.id.recycle2);
        vaccinate = (Button)findViewById(R.id.button9);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(RoutineActivity2.this, HomeActivity2.class);
                startActivity(i);
                finish();

            }
        });

        initData();
        setRecyclerView();

        vaccinate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://selfregistration.cowin.gov.in/"));
                startActivity(browserIntent);
                finish();
            }
        });

    }

    private void setRecyclerView() {
        VersionsAdapter versionsAdapter = new VersionsAdapter(versionsList);
        recyclerView.setAdapter(versionsAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {
        versionsList = new ArrayList<>();

        versionsList.add(new Versions("Why should I take the vaccine?", "Taking vaccine is really important as it makes your immune system stronger and produces the antibodies to fight the corona virus. As the different variants are taking over bodies and making the situation worse, a vaccinated person will not face such issues and will be recovered with minimal symptoms"));
        versionsList.add(new Versions("Which COVID-19 vaccines are licensed in India?", "Two vaccines were granted emergency use authorization by the Central Drugs Standard ControlOrganization in India, Covishield®India and Covaxin® Sputnik - V has been granted EUA in the month of April 2021"));
        versionsList.add(new Versions("What is the optimal time interval between the required two shots?", "The time interval between two doses of the Covishield vaccine has been extended from four-six weeks to four-eight weeks, while the second dose of Covaxin can be taken four to six weeks after the first."));
        versionsList.add(new Versions("How long I will remain protected after vaccination?", "Longevity of the immune response in vaccinated individuals is yet to be determined. Hence, continuing the use of masks, handwashing, physical distancing and other COVID-19 appropriate behaviours is strongly recommended."));
        versionsList.add(new Versions("Can a person presently having COVID-19 (confirmed or suspected) infection be vaccinated?", "Person with confirmed or suspected COVID-19 infection may increase the risk of spreading the same to others at vaccination site. For this reason, infected individuals should defer vaccination for 14 days after symptoms resolution."));
        versionsList.add(new Versions("Where should I register for the vaccination?", "Register on the Co-WIN Portal and schedule your vaccination appointment. https://www.cowin.gov.in/home. You can also register on the Arogya setu app."));
        versionsList.add(new Versions("Is it important for me to receive the same vaccine during second dose?","As the vaccines available are not interchangeable, it is important to receive the second dose of same vaccine as the first one. The Co-WIN portal is also going to help to ensure that everyone receives the same vaccine."));
    }
}