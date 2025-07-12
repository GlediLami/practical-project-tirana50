package org.sda.dto.forecast;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.time.OffsetDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class DailyForecastDto {

    @JsonProperty("Date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") // matches 2025‑07‑16T07:00:00+02:00
    private OffsetDateTime date;

    @JsonProperty("Temperature")
    private TemperatureDto temperature;

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public TemperatureDto getTemperature() {
        return temperature;
    }

    public void setTemperature(TemperatureDto temperature) {
        this.temperature = temperature;
    }
}
