package org.sda.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sda.dto.ForecastDto;
import org.sda.util.ApplicationConstants;
import org.sda.util.HttpClientService;

public class ForecastService {

    private HttpClientService httpClientService;

    public ForecastService(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }

    public ForecastDto getForecastForOneDay(String cityId){
        String uri = ApplicationConstants.API_BASE_URL + "/forecasts/v1/daily/1day/" + cityId + "?apikey=" + ApplicationConstants.API_KEY + "&metric=true";
        String response = httpClientService.getRequest(uri);

        ForecastDto forecastDto = convertToDto(response);

        System.out.println("Forecast for city: " + cityId + " => " + forecastDto);
        return forecastDto;
    }

    private static ForecastDto convertToDto(String response) {
        ObjectMapper mapper = new ObjectMapper();
        ForecastDto forecastDto = new ForecastDto();
        try {
            forecastDto = mapper.readValue(response, ForecastDto.class);
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
        return forecastDto;
    }

    public static void main(String[] args) {
        ForecastService forecastService = new ForecastService(new HttpClientService());
        forecastService.getForecastForOneDay("4552");
    }

}
