package com.iase24.ipsearcher.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class WeatherDataDtoResponse {
    private List<WeatherFromList> weather;
    private MainWeatherResponse main;
    private String timezone;
    private String name;
    private CoordinateResponse coord;
}
