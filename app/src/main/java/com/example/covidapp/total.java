package com.example.covidapp;

public class total {
    String total_cases, total_death, total_recovered, total_icu, total_treatment;

    public total(String total_cases, String total_death, String total_recovered, String total_icu, String total_treatment) {
        this.total_cases = total_cases;
        this.total_death = total_death;
        this.total_recovered = total_recovered;
        this.total_icu = total_icu;
        this.total_treatment = total_treatment;
    }

    public String getTotal_cases() {
        return total_cases;
    }

    public void setTotal_cases(String total_cases) {
        this.total_cases = total_cases;
    }

    public String getTotal_death() {
        return total_death;
    }

    public void setTotal_death(String total_death) {
        this.total_death = total_death;
    }

    public String getTotal_recovered() {
        return total_recovered;
    }

    public void setTotal_recovered(String total_recovered) {
        this.total_recovered = total_recovered;
    }

    public String getTotal_icu() {
        return total_icu;
    }

    public void setTotal_icu(String total_icu) {
        this.total_icu = total_icu;
    }

    public String getTotal_treatment() {
        return total_treatment;
    }

    public void setTotal_treatment(String total_treatment) {
        this.total_treatment = total_treatment;
    }
}
