package com.hysstory.covidtracker.services;

import com.hysstory.covidtracker.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CovidDataService {

    private final static String COVID_DATA_NYTIMES_URL =
            "https://raw.githubusercontent.com/nytimes/covid-19-data/master/live/us-states.csv";

    public List<LocationStats> getAllStats() {
        return allStats;
    }

    private List<LocationStats> allStats = new ArrayList<>();

    @PostConstruct
    @Scheduled(cron = "* * * 1 * *")

    public void fetchCovidData() throws IOException, InterruptedException {
        List<LocationStats> stats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(URI.create(COVID_DATA_NYTIMES_URL))
                        .build();
        HttpResponse<String> httpResponse =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records =
                CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .parse(csvBodyReader);

        for (CSVRecord record : records) {
            LocationStats data = new LocationStats();
            data.setState(record.get("state"));
            data.setCases(Integer.parseInt(record.get("cases")));
            data.setDeaths(Integer.parseInt(record.get("deaths")));
            stats.add(data);
        }
        this.allStats = stats;
    }
}
