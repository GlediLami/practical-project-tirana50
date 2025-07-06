package org.sda.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.sda.dto.location.CityDto;
import org.sda.dto.location.CountryDto;
import org.sda.dto.location.RegionDto;
import org.sda.util.ApplicationConstants;
import org.sda.util.HttpClientService;
import org.sda.util.JsonConverterService;

import java.util.List;

public class LocationService {

    public List<RegionDto> getAllRegions() {
        String response = HttpClientService.getRequest(ApplicationConstants.API_BASE_URL + "/locations/v1/regions/?apikey=" + ApplicationConstants.API_KEY);

        List<RegionDto> regionDtos = JsonConverterService.convertToDtoList(response);
        System.out.println(regionDtos);
        return regionDtos;
    }

    public static void main(String[] args) {
        LocationService locationService = new LocationService();
        locationService.getAllCitiesOfCountry("AL");
    }

    public List<CountryDto> getAllCountriesOfRegion(String regionId) {
        String response = HttpClientService.getRequest(ApplicationConstants.API_BASE_URL + "/locations/v1/countries/" + regionId + "?apikey=" + ApplicationConstants.API_KEY);
        List<CountryDto> countryDtos = JsonConverterService.convertToDtoList(response);
        System.out.println(countryDtos);
        return countryDtos;
    }


    public List<CityDto> getAllCitiesOfCountry(String countryCode) {
        String response = HttpClientService.getRequest(ApplicationConstants.API_BASE_URL + "/locations/v1/cities/" + countryCode + "?apikey=" + ApplicationConstants.API_KEY);
        List<CityDto> cityDtos = JsonConverterService.convertToDtoList(response);
        System.out.println(cityDtos);
        return cityDtos;
    }

//    public City getCityDetails(String cityId){}
//
//    public boolean doesCityExist(String cityId){}
//
//    // OTHER METHODS AS NEEDED
}