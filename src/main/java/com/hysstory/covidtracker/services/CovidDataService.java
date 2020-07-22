package com.hysstory.covidtracker.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CovidDataService {

    private final static String COVID_DATA_NYTIMES_URL =
            "https://raw.githubusercontent.com/nytimes/covid-19-data/master/live/us-states.csv";

    public void fetchCovidData() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =
                HttpRequest.newBuilder()
                            .uri(URI.create(COVID_DATA_NYTIMES_URL))
                            .build();
        client.send((request, HttpResponse.BodyHandler.))
    }
}
