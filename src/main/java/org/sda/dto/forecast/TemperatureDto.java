package org.sda.dto.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

// Temperature class
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class TemperatureDto {

    @JsonProperty("Minimum")
    private TemperatureValueDto minimum;

    @JsonProperty("Maximum")
    private TemperatureValueDto maximum;

    // Getters and setters
    public TemperatureValueDto getMinimum() {
        return minimum;
    }

    public void setMinimum(TemperatureValueDto minimum) {
        this.minimum = minimum;
    }

    public TemperatureValueDto getMaximum() {
        return maximum;
    }

    public void setMaximum(TemperatureValueDto maximum) {
        this.maximum = maximum;
    }
}
