package com.projects.coronavirustracker.service;

import com.projects.coronavirustracker.globals.GlobalConstants;
import com.projects.coronavirustracker.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CoronaVirusDataService {

    private List<LocationStats> allStats = new ArrayList<>();

    public List<LocationStats> getAllStats() {
        return allStats;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchData() throws IOException, InterruptedException {

        List<LocationStats> newStats = new ArrayList<>();

        // HTTP call to coronavirus data url
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(GlobalConstants.CORONA_VIRUS_DATA))
                .build();

        HttpResponse<String> httpResponse =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Iterate through DATA
        StringReader csvBodyReader = new StringReader(httpResponse.body());

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            LocationStats locationStat = new LocationStats();
            locationStat.setState(record.get("Province/State"));
            locationStat.setCountry(record.get("Country/Region"));
            locationStat.setLatestReportedCases(Integer.parseInt(record.get(record.size() - 1)));

            newStats.add(locationStat);
        }

        this.allStats = newStats;
    }
}
