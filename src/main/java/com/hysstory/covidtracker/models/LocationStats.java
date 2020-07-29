package com.hysstory.covidtracker.models;

public class LocationStats {

    private String state;
    private int cases;
    private int death;

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

    public int getDeath() {
        return death;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", cases=" + cases +
                ", death=" + death +
                '}';
    }

    public void setDeath(int death) {
        this.death = death;

    }
}
