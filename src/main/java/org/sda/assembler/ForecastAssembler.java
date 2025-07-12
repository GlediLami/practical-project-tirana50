package org.sda.assembler;

import org.sda.dto.forecast.DailyForecastDto;
import org.sda.dto.forecast.ForecastDto;
import org.sda.entity.Forecast;

public class ForecastAssembler implements GenericAssembler<Forecast, ForecastDto> {

    // This method expects a ForecastDto object with a single DailyForecastDto
    @Override
    public Forecast assemble(ForecastDto object) {
        Forecast forecast = new Forecast();
        DailyForecastDto dto = object.getDailyForecastDtos().getFirst();
        forecast.setDate(dto.getDate());
        forecast.setMinimumValue(dto.getTemperature().getMinimum().getValue());
        forecast.setMaximumValue(dto.getTemperature().getMaximum().getValue());
        return forecast;
    }
}
