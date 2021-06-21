package com.example.covidapp.adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.covidapp.R;
import com.example.covidapp.model.VaccineModel;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VaccinationInfoAdapter extends RecyclerView.Adapter<VaccinationInfoAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<VaccineModel> list_vaccine_center;

    public VaccinationInfoAdapter(Context mcontext, List<VaccineModel> list_vaccine_center) {
        this.layoutInflater = LayoutInflater.from(mcontext);
        this.list_vaccine_center = list_vaccine_center;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.vaccination_info_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.vaccineCenter.setText(list_vaccine_center.get(position).getVaccineCenter());
        holder.vaccineCenterAddr.setText(list_vaccine_center.get(position).getVaccineCenterAddr());
        holder.vaccineTime.setText(list_vaccine_center.get(position).getVaccineTime() + " - " + list_vaccine_center.get(position).getVaccineCenterTime());
        holder.vaccineName.setText(list_vaccine_center.get(position).getVaccineName());
        holder.vaccineAvailable.setText(list_vaccine_center.get(position).getVaccineAvailable());
        holder.vaccineCharges.setText(list_vaccine_center.get(position).getVaccineCharges());
        holder.vaccineAge.setText(list_vaccine_center.get(position).getVaccineAge());

    }

    @Override
    public int getItemCount() {
        return list_vaccine_center.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView vaccineCenter;
        TextView vaccineName;
        TextView vaccineCharges;
        TextView vaccineAge;
        TextView vaccineTime;
        TextView vaccineAvailable;
        TextView vaccineCenterTime;
        TextView vaccineCenterAddr;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            vaccineAge = itemView.findViewById(R.id.vaccineAge);
            vaccineAvailable = itemView.findViewById(R.id.isAvailable);
            vaccineCharges = itemView.findViewById(R.id.vaccineCharges);
            vaccineName = itemView.findViewById(R.id.vaccineName);
            vaccineTime = itemView.findViewById(R.id.vaccineTime);
            vaccineCenter = itemView.findViewById(R.id.vaccineCenter);
            vaccineCenterAddr = itemView.findViewById(R.id.vaccineLocation);

        }
    }

}
