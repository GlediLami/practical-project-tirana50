package org.sda.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ForecastDto {

    @JsonProperty("DailyForecasts")
    private List<DailyForecastDto> DailyForecastDtos;


    // Getters and setters
    public List<DailyForecastDto> getDailyForecastDtos() {
        return DailyForecastDtos;
    }


    public void setDailyForecastDtos(List<DailyForecastDto> DailyForecastDtos) {
        this.DailyForecastDtos = DailyForecastDtos;
    }
}