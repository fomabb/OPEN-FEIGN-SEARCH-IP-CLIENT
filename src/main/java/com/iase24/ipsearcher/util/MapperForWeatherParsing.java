package com.iase24.ipsearcher.util;

import com.iase24.ipsearcher.dto.CoordinateResponse;
import com.iase24.ipsearcher.dto.MainWeatherResponse;
import com.iase24.ipsearcher.dto.WeatherDataDtoResponse;
import com.iase24.ipsearcher.dto.WeatherFromList;
import com.iase24.ipsearcher.dto.Wind;

public class MapperForWeatherParsing {

    public static MapperFromFeignClientWeather getMapperFromFeignClientWeather(WeatherDataDtoResponse response) {
        WeatherFromList weatherFromList = WeatherFromList.builder()
                .id(response.getWeather().getFirst().getId())
                .main(response.getWeather().getFirst().getMain())
                .description(response.getWeather().getFirst().getDescription())
                .icon(response.getWeather().getFirst().getIcon())
                .build();

        Wind wind = Wind.builder().speed(response.getWind().getSpeed()).build();

        MainWeatherResponse mainWeatherResponse = MainWeatherResponse.builder()
                .temp(response.getMain().getTemp())
                .feels_like(response.getMain().getFeels_like())
                .build();

        String timezoneResponse = response.getTimezone();
        String nameCity = response.getName();
        CoordinateResponse coord = CoordinateResponse.builder().lon(response.getCoord().getLon()).lat(response.getCoord().getLat()).build();

        return new MapperFromFeignClientWeather(weatherFromList, wind, mainWeatherResponse, timezoneResponse, nameCity, coord);
    }

    public record MapperFromFeignClientWeather(
            WeatherFromList weatherFromList,
            Wind wind,
            MainWeatherResponse mainWeatherResponse,
            String timezone,
            String nameCity,
            CoordinateResponse coord) {
    }
}
