package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Statistics extends AppCompatActivity {

    TextView tvactive, tvaffected, tvrecovered, tvdeath;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        back = findViewById(R.id.imageView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(Statistics.this, HomeActivity2.class);
                startActivity(i);
                finish();

            }
        });

        tvrecovered = findViewById(R.id.tvrecovered);
        tvactive = findViewById(R.id.tvactive);
        tvaffected = findViewById(R.id.tvaffected);
        tvdeath = findViewById(R.id.tvdeath);
        fetchdata();
    }

    private void fetchdata() {

        String url = "https://disease.sh/v3/covid-19/countries/india";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());

                            tvactive.setText(jsonObject.getString("active"));
                            tvrecovered.setText(jsonObject.getString("recovered"));
                            tvaffected.setText(jsonObject.getString("cases"));
                            tvdeath.setText(jsonObject.getString("deaths"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Statistics.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
