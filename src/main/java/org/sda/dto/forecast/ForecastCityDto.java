package org.sda.dto.forecast;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForecastCityDto {
    private ForecastDto forecastDto;
    private String cityId;
}
