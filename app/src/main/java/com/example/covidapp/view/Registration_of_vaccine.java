package com.example.covidapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covidapp.R;
import com.example.covidapp.Statistics;
import com.example.covidapp.adapter.VaccinationInfoAdapter;
import com.example.covidapp.model.VaccineModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.SimpleTimeZone;

public class Registration_of_vaccine extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    String baseURL = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?";
    private EditText areaPINcode;
    private Button forwardbtn;
    ProgressBar holdOnProgress;
    private ArrayList<VaccineModel> vaccination_centers;
    private RecyclerView resultRecyclerView;
    String areaPIN, avlDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration_of_vaccine);
        mapViews();
        onClickSetUp();

    }

    private void onClickSetUp() {

        forwardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holdOnProgress.setVisibility(View.VISIBLE);
                DialogFragment dp = new PickDate();
                dp.show(getSupportFragmentManager(), "pick a date");

            }
        });

    }

    private void mapViews() {

        forwardbtn = findViewById(R.id.search);
        holdOnProgress = findViewById(R.id.progress1);
        areaPINcode = findViewById(R.id.pincode);
        resultRecyclerView = findViewById(R.id.recycle1);
        vaccination_centers = new ArrayList<VaccineModel>();
        resultRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

        Calendar k =  Calendar.getInstance();
        k.set(Calendar.YEAR, year);
        k.set(Calendar.MONTH, month);
        k.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        dateFormat.setTimeZone(k.getTimeZone());
        String d = dateFormat.format(k.getTime());
        setup(d);

    }

    private void setup(String d) {
        avlDate = d;
        fetchDataNow();
    }

    private void fetchDataNow() {

        vaccination_centers.clear();
        areaPIN = areaPINcode.getText().toString();
        String url_api = baseURL + "pincode=" + areaPIN + "&date=" + avlDate;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_api, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            JSONArray sessionArray = object.getJSONArray("sessions");

                            for(int i =0; i < sessionArray.length(); i++){

                                JSONObject sesObject = sessionArray.getJSONObject(i);
                                VaccineModel vaccineModel = new VaccineModel();
                                vaccineModel.setVaccineCenter(sesObject.getString("name"));
                                vaccineModel.setVaccineCenterAddr(sesObject.getString("address"));
                                vaccineModel.setVaccineTime(sesObject.getString("from"));
                                vaccineModel.setVaccineCenterTime(sesObject.getString("to"));
                                vaccineModel.setVaccineName(sesObject.getString("vaccine"));
                                vaccineModel.setVaccineCharges(sesObject.getString("fee_type"));
                                vaccineModel.setVaccineAge(sesObject.getString("min_age_limit"));
                                vaccineModel.setVaccineAvailable(sesObject.getString("available_capacity"));
                                vaccination_centers.add(vaccineModel);
                            }

                            VaccinationInfoAdapter vaccinationInfoAdapter = new VaccinationInfoAdapter(getApplicationContext(), vaccination_centers);
                            resultRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            resultRecyclerView.setAdapter(vaccinationInfoAdapter);
                            holdOnProgress.setVisibility(View.INVISIBLE);

                        } catch (JSONException e) {
                            holdOnProgress.setVisibility(View.INVISIBLE);
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        holdOnProgress.setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(stringRequest);
    }
}