package org.sda.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientService {

    public static String getRequest(String url){
        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP GET Request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Send request and get response as String
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e){
            System.out.println(e);
        }
        // Print raw JSON response
        System.out.println("Raw JSON Response: " + response.body());
        return response.body();
    }

}
