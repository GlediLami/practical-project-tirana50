package org.sda.service;

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
        System.out.println(locationService.doesCityExist("4552"));
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

    public CityDto getCityDetails(String cityId){
        String response = HttpClientService.getRequest(ApplicationConstants.API_BASE_URL + "/locations/v1/" + cityId + "9999?apikey=" + ApplicationConstants.API_KEY);
        CityDto city = JsonConverterService.convertToDto(response, CityDto.class);

        System.out.println(city);

        return city;
    }

//
    public boolean doesCityExist(String cityId){
        CityDto city = this.getCityDetails(cityId);
        return city != null;
    }
//
//    // OTHER METHODS AS NEEDED
}