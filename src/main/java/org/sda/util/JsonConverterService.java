package org.sda.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverterService {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T convertToDto(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            System.out.println("Error parsing JSON into " + clazz.getSimpleName() + ": " + e.getMessage());
            return null;
        }
    }

    // Only use this when you have Lists to convert: List<ForecastDto> list = JsonUtil.convertToDto(jsonString, new TypeReference<List<ForecastDto>>() {});
    public static <T> T convertToDtoList(String json) {
        try {
            return mapper.readValue(json, new TypeReference<> () {});
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
            return null;
        }
    }
}
