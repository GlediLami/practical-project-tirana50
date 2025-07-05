package org.sda.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class TemperatureValueDto {

    @JsonProperty("Value")
    private double value;

    @JsonProperty("Unit")
    private String unit;

    // Getters and setters
    public double getValue() {
        return value;
    }    public void setValue(double value) {
        this.value = value;
    }    public String getUnit() {
        return unit;
    }    public void setUnit(String unit) {
        this.unit = unit;
    }
}