package com.example.covidapp.model;

public class VaccineModel {

    private String vaccineCenter;
    private String vaccineName;
    private String vaccineCharges;
    private String vaccineTime;
    private String vaccineAge;
    private String vaccineAvailable;
    private String vaccineCenterTime;
    private String vaccineCenterAddr;

    public VaccineModel()
    {
    }

    public String getVaccineCenter() {
        return vaccineCenter;
    }

    public void setVaccineCenter(String vaccineCenter) {
        this.vaccineCenter = vaccineCenter;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineCharges() {
        return vaccineCharges;
    }

    public void setVaccineCharges(String vaccineCharges) {
        this.vaccineCharges = vaccineCharges;
    }

    public String getVaccineTime() {
        return vaccineTime;
    }

    public void setVaccineTime(String vaccineTime) {
        this.vaccineTime = vaccineTime;
    }

    public String getVaccineAge() {
        return vaccineAge;
    }

    public void setVaccineAge(String vaccineAge) {
        this.vaccineAge = vaccineAge;
    }

    public String getVaccineAvailable() {
        return vaccineAvailable;
    }

    public void setVaccineAvailable(String vaccineAvailable) {
        this.vaccineAvailable = vaccineAvailable;
    }

    public String getVaccineCenterTime() {
        return vaccineCenterTime;
    }

    public void setVaccineCenterTime(String vaccineCenterTime) {
        this.vaccineCenterTime = vaccineCenterTime;
    }

    public String getVaccineCenterAddr() {
        return vaccineCenterAddr;
    }

    public void setVaccineCenterAddr(String vaccineCenterAddr) {
        this.vaccineCenterAddr = vaccineCenterAddr;
    }

    public VaccineModel(String vaccineCenter, String vaccineName, String vaccineCharges, String vaccineTime, String vaccineAge, String vaccineAvailable, String vaccineCenterTime, String vaccineCenterAddr) {
        this.vaccineCenter = vaccineCenter;
        this.vaccineName = vaccineName;
        this.vaccineCharges = vaccineCharges;
        this.vaccineTime = vaccineTime;
        this.vaccineAge = vaccineAge;
        this.vaccineAvailable = vaccineAvailable;
        this.vaccineCenterTime = vaccineCenterTime;
        this.vaccineCenterAddr = vaccineCenterAddr;
    }
}
