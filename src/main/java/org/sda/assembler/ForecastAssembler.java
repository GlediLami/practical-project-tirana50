package org.sda.assembler;

import org.sda.dto.forecast.DailyForecastDto;
import org.sda.dto.forecast.ForecastCityDto;
import org.sda.entity.Forecast;

public class ForecastAssembler implements GenericAssembler<Forecast, ForecastCityDto> {

    // This method expects a ForecastDto object with a single DailyForecastDto
    @Override
    public Forecast assemble(ForecastCityDto object) {
        Forecast forecast = new Forecast();
        DailyForecastDto dto = object.getForecastDto().getDailyForecastDtos().getFirst();
        forecast.setDate(dto.getDate());
        forecast.setMinTemp(dto.getTemperature().getMinimum().getValue());
        forecast.setMaxTemp(dto.getTemperature().getMaximum().getValue());
        forecast.setCityId(object.getCityId());
        return forecast;
    }
}
