package com.geogeniusback.geogeniusback.dto;

public class QuizRequest {
    private String mode;
    private List<String> countries;


    public String getMode() {
        return this.mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<String> getCountries() {
        return this.countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }
    
}
