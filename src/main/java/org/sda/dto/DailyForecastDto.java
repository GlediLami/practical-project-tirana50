package org.sda.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class DailyForecastDto {

    @JsonProperty("Date")
    private String date; // You can also use LocalDateTime with custom deserializer

    @JsonProperty("Temperature")
    private TemperatureDto temperature;

    // Getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public TemperatureDto getTemperature() {
        return temperature;
    }

    public void setTemperature(TemperatureDto temperature) {
        this.temperature = temperature;
    }
}
