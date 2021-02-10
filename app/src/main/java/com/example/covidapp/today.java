package com.example.covidapp;

public class today {
    String today_cases, today_death, today_recovered, today_icu, today_treatment;

    public today(String today_cases, String today_death, String today_recovered, String today_icu, String today_treatment) {
        this.today_cases = today_cases;
        this.today_death = today_death;
        this.today_recovered = today_recovered;
        this.today_icu = today_icu;
        this.today_treatment = today_treatment;
    }

    public String getToday_cases() {
        return today_cases;
    }

    public void setToday_cases(String today_cases) {
        this.today_cases = today_cases;
    }

    public String getToday_death() {
        return today_death;
    }

    public void setToday_death(String today_death) {
        this.today_death = today_death;
    }

    public String getToday_recovered() {
        return today_recovered;
    }

    public void setToday_recovered(String today_recovered) {
        this.today_recovered = today_recovered;
    }

    public String getToday_icu() {
        return today_icu;
    }

    public void setToday_icu(String today_icu) {
        this.today_icu = today_icu;
    }

    public String getToday_treatment() {
        return today_treatment;
    }

    public void setToday_treatment(String today_treatment) {
        this.today_treatment = today_treatment;
    }
}
