package com.projects.coronavirustracker.models;

import java.util.Date;

public class LocationStats {

    public LocationStats(){}

    private String state;
    private String country;
    private int latestReportedCases;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestReportedCases() {
        return latestReportedCases;
    }

    public void setLatestReportedCases(int latestReportedCases) {
        this.latestReportedCases = latestReportedCases;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestReportedCases=" + latestReportedCases +
                '}';
    }
}
