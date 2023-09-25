package com.live.coderound.hubspot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Partner {
    public String firstName;
    public String lastName;
    public String email;
    public String country;
    public ArrayList<String> availableDates;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<String> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(ArrayList<String> availableDates) {
        this.availableDates = availableDates;
    }
}

class PartnerList {
    public ArrayList<Partner> partners;

    public ArrayList<Partner> getPartners() {
        return partners;
    }

    public void setPartners(ArrayList<Partner> partners) {
        this.partners = partners;
    }
}

class Country {
    public int attendeeCount;
    public ArrayList<String> attendees;
    public String name;
    public String startDate;

    public Country(String country, int size, List<String> emails, String mostAvailDate) {
        this.attendeeCount = size;
        this.name = country;
        this.startDate = mostAvailDate;
        this.attendees = (ArrayList<String>) emails;
    }

    public int getAttendeeCount() {
        return attendeeCount;
    }

    public void setAttendeeCount(int attendeeCount) {
        this.attendeeCount = attendeeCount;
    }
}

public class OnlineAssessment {

    private static final String USER_KEY = "8c3b395e7e8be96b27d2818d8c77";
    private static final String FETCH_API_URL = "https://candidate.hubteam.com/candidateTest/v3/problem/dataset?userKey=" + USER_KEY;
    private static final String POST_API_URL = "https://candidate.hubteam.com/candidateTest/v3/problem/result?userKey=" + USER_KEY;

    public static void main(String[] args) {
        OnlineAssessment onlineAssessment = new OnlineAssessment();
        try {

            HttpClient httpClient = HttpClient.newHttpClient();

            // HTTP Request to fetch data from FETCH_API_URL
            HttpRequest dataRequest = HttpRequest.newBuilder()
                    .uri(URI.create(FETCH_API_URL))
                    .build();
            HttpResponse<String> dataResponse = httpClient.send(dataRequest, HttpResponse.BodyHandlers.ofString());
            String jsonBodyString = dataResponse.body();

            // Parse the JSON data into partnerList or data structures as needed

            PartnerList partnerList = onlineAssessment.parseJson(jsonBodyString);

            // Get the list of partners
            ArrayList<Partner> partners = partnerList.getPartners();

            // Create a HashMap to store partnerList by country

            HashMap<String, ArrayList<Partner>> partnerMapByCountry = onlineAssessment.generatePartnerByCountry(partners);

            // List to store results for each country
            List<Country> countries = onlineAssessment.getCountryList(partnerMapByCountry);

            // Send data to POST_API_URL
            Map<String, Object> requestData = new HashMap<>();
            requestData.put("countries", countries);

            ObjectMapper objectMapper = new ObjectMapper();

            String requestBody = objectMapper.writeValueAsString(requestData);

            // Build the HttpRequest
            HttpRequest resultRequest = HttpRequest.newBuilder()
                    .uri(URI.create(POST_API_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> resultResponse = httpClient.send(resultRequest, HttpResponse.BodyHandlers.ofString());
            String resultResponseBody = resultResponse.body();
            System.out.println("API Response " + resultResponseBody + " Status Code: "+resultResponse.statusCode());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Get the list of countries and their corresponding partners, filter the partners by their ideal start date and return the list of countries.
     *
     * @param
     * @return
     */

    private List<Country> getCountryList(HashMap<String, ArrayList<Partner>> partnerMapByCountry) {
        List<Country> countries = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Partner>> entry : partnerMapByCountry.entrySet()) {
            List<Partner> partnersByCountry = entry.getValue();
            Country country = findIdealStartDatePartners(entry.getKey(), partnersByCountry);
            countries.add(country);
        }
        return countries;
    }

    /**
     * Find the ideal start date for each country and return the country with the most available partners.
     *
     * @param country
     * @param partners
     * @return
     */
    private Country findIdealStartDatePartners(String country, List<Partner> partners) {
        Map<String, List<Partner>> partnersByDate = new HashMap<>();
        String mostAvailDate = null;
        int maxAttendee = -1;

        for (Partner p : partners) {
            List<String> partnerAvailableDates = p.getAvailableDates();
            List<String> filteredAvailableDates = new ArrayList<>();

            // Filter out all the potential start day and put it under partnerAvailableDates
            for (int i = 0; i < partnerAvailableDates.size() - 1; i++) {
                if (LocalDate.parse(partnerAvailableDates.get(i)).plusDays(1).toString().equals(partnerAvailableDates.get(i + 1))) {
                    filteredAvailableDates.add(partnerAvailableDates.get(i));
                }
            }

            if (!filteredAvailableDates.isEmpty()) {
                for (String date : filteredAvailableDates) {
                    partnersByDate.computeIfAbsent(date, k -> new ArrayList<>()).add(p);
                    int partnerCount = partnersByDate.get(date).size();
                    if (partnerCount > maxAttendee) {
                        mostAvailDate = date;
                        maxAttendee = partnerCount;
                    }
                }
            }

        }
        List<Partner> attendeeList = (mostAvailDate != null && partnersByDate.containsKey(mostAvailDate)) ? partnersByDate.get(mostAvailDate) : new ArrayList<>();
        int partnerSize = attendeeList.size();

        List<String> emails = new ArrayList<>();

        // Iterate through the partners and extract emails
        for (Partner partner : attendeeList) {
            String email = partner.getEmail();
            if (email != null) {
                emails.add(email);
            }
        }

        return new Country(country, partnerSize, emails, mostAvailDate);
    }

    /**
     * Generate a map of partners by country
     *
     * @param partners
     * @return
     */
    private HashMap<String, ArrayList<Partner>> generatePartnerByCountry(ArrayList<Partner> partners) {
        HashMap<String, ArrayList<Partner>> partnersByCountry = new HashMap<>();
        // Iterate through the partners and group them by country
        for (Partner partner : partners) {
            String country = partner.getCountry();
            if (!partnersByCountry.containsKey(country)) {
                // If the country is not already in the map, create a new ArrayList
                partnersByCountry.put(country, new ArrayList<>());
            }
            // Add the partner to the corresponding country's list
            partnersByCountry.get(country).add(partner);
        }
        return partnersByCountry;
    }

    private PartnerList parseJson(String jsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        PartnerList person = objectMapper.readValue(jsonString, PartnerList.class);
        return person;
    }


}
