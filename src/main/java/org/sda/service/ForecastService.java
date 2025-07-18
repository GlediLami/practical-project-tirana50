package org.sda.service;

import org.sda.dto.forecast.DailyForecastDto;
import org.sda.dto.forecast.ForecastCityDto;
import org.sda.dto.forecast.ForecastDto;
import org.sda.util.ApplicationConstants;
import org.sda.util.HttpClientService;
import org.sda.util.JsonConverterService;

import java.util.List;

public class ForecastService {

    public ForecastCityDto getForecastForOneDay(String cityId){
        String uri = ApplicationConstants.API_BASE_URL + "/forecasts/v1/daily/1day/" + cityId + "?apikey=" + ApplicationConstants.API_KEY + "&metric=true";
        String response = HttpClientService.getRequest(uri);

        ForecastDto forecastDto = JsonConverterService.convertToDto(response, ForecastDto.class);

        System.out.println("Forecast for city: " + cityId + " => " + forecastDto);

        return new ForecastCityDto(forecastDto, cityId);
    }

    public List<DailyForecastDto> getForecastForFiveDay(String cityId){
        String uri = ApplicationConstants.API_BASE_URL + "/forecasts/v1/daily/5day/" + cityId + "?apikey=" + ApplicationConstants.API_KEY + "&metric=true";
        String response = HttpClientService.getRequest(uri);

        ForecastDto forecastDto = JsonConverterService.convertToDto(response, ForecastDto.class);

        System.out.println("Forecast for city: " + cityId + " => " + forecastDto);

        return forecastDto.getDailyForecastDtos();
    }

    public void showAverageTemperatureForFiveDays(String cityId){
        List<DailyForecastDto> forecastDtos = getForecastForFiveDay(cityId);
        double average = 0;

        for (DailyForecastDto forecast : forecastDtos){
            average += (forecast.getTemperature().getMaximum().getValue() +
                    forecast.getTemperature().getMinimum().getValue() ) / 2;
        }

        average /= forecastDtos.size();

        System.out.println("Average temperature for 5 days is: " + average);

    }

    public static void main(String[] args) {
        ForecastService forecastService = new ForecastService();
        forecastService.getForecastForOneDay("4552");
    }

}
