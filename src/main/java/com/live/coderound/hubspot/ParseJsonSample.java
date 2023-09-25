package com.live.coderound.hubspot;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;


public class ParseJsonSample {
    public String getJsonString(String fileName){
        String jsonString = null;
        try {
            // Replace "your-json-file.json" with the path to your JSON file
            File file = new File(fileName);

            // Create a FileInputStream to read the file
            FileInputStream fileInputStream = new FileInputStream(file);

            // Create a Scanner to read from the FileInputStream
            Scanner scanner = new Scanner(fileInputStream);

            // Use a StringBuilder to store the JSON data
            StringBuilder jsonStringBuilder = new StringBuilder();

            // Read the file line by line
            while (scanner.hasNextLine()) {
                jsonStringBuilder.append(scanner.nextLine());
            }

            // Close the scanner and fileInputStream
            scanner.close();
            fileInputStream.close();

            // Extract the JSON string from the StringBuilder
            jsonString = jsonStringBuilder.toString();

            return jsonString;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }
    private static final String USER_KEY = "YOUR_USER_KEY";
    private static final String DATASET_API = "https://candidate.hubteam.com/candidateTest/v3/problem/dataset?userKey=" + USER_KEY;
    private static final String RESULT_API = "https://candidate.hubteam.com/candidateTest/v3/problem/result?userKey=" + USER_KEY;

    public static void main(String[] args) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();

            // Fetch data from DATASET_API
            HttpRequest dataRequest = HttpRequest.newBuilder()
                    .uri(URI.create(DATASET_API))
                    .build();
            HttpResponse<String> dataResponse = httpClient.send(dataRequest, HttpResponse.BodyHandlers.ofString());
            String dataResponseBody = dataResponse.body();
/**
            // Parse the JSON data
            // You can use a JSON library like Jackson or Gson for more advanced JSON parsing
            // Here, we'll use simple String manipulation for demonstration purposes
            // Assume that the JSON data contains fields: partners, country, availableDates, email, etc.
            // Parse the JSON data into objects or data structures as needed
            // ...

            // Group partners by country
            Map<String, List<Partner>> groupByCountries = new HashMap<>();
            // Implement the Partner class to store partner data

            // Loop through partners and group them by country
            // ...

            // List to store results for each country
            List<Country> countries = new ArrayList<>();

            for (Map.Entry<String, List<Partner>> entry : groupByCountries.entrySet()) {
                String country = entry.getKey();
                List<Partner> partners = entry.getValue();

                Country countryResult = findIdealStartDatePartners(country, partners);
                countries.add(countryResult);
            }

            // Prepare the data for RESULT_API
            Map<String, Object> requestData = new HashMap<>();
            requestData.put("countries", countries);

            // Send data to RESULT_API
            HttpRequest resultRequest = HttpRequest.newBuilder()
                    .uri(URI.create(RESULT_API))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(JsonUtils.toJson(requestData))) // Use a JSON serialization library here
                    .build();

            HttpResponse<String> resultResponse = httpClient.send(resultRequest, HttpResponse.BodyHandlers.ofString());
            String resultResponseBody = resultResponse.body();

            // Parse and handle the response from RESULT_API
            // ...
**/
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
/**
    private static Country findIdealStartDatePartners(String country, List<Partner> partners) {
        Map<String, List<Partner>> partnersByDate = new HashMap<>();
        String mostAvailDate = null;
        int maxAttendee = -1;

        for (Partner p : partners) {
            List<String> availableDates = p.getAvailableDates();
            List<String> availDates = new ArrayList<>();

            // Filter out all the potential start day and put it under availableDates
            for (int i = 0; i < availableDates.size() - 1; i++) {
                if (LocalDate.parse(availableDates.get(i)).plusDays(1).toString().equals(availableDates.get(i + 1))) {
                    availDates.add(availableDates.get(i));
                }
            }

            if (!availDates.isEmpty()) {
                for (String date : availDates) {
                    partnersByDate.computeIfAbsent(date, k -> new ArrayList<>()).add(p);
                    int partnerCount = partnersByDate.get(date).size();
                    if (partnerCount > maxAttendee) {
                        mostAvailDate = date;
                        maxAttendee = partnerCount;
                    }
                }
            }
        }

        return new Country(country, partnersByDate.get(mostAvailDate).size(), partnersByDate.get(mostAvailDate), mostAvailDate);
    }
 **/

}

