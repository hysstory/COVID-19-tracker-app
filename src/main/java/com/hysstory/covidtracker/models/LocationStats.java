package com.hysstory.covidtracker.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.ModelAttribute;

public class LocationStats {

    private String state;
    private int cases;
    private int deaths;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getDeaths() {
        return deaths;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", cases=" + cases +
                ", death=" + deaths +
                '}';
    }

    public void setDeaths(int death) {
        this.deaths = death;

    }
}
