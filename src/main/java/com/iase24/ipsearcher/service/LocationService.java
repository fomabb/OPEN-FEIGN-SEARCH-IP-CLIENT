package com.iase24.ipsearcher.service;

import com.iase24.ipsearcher.dto.LocationClientByIpResponse;
import com.iase24.ipsearcher.dto.WeatherDataDtoResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface LocationService {

    LocationClientByIpResponse getLocationByIp(String lang, HttpServletRequest request);

    WeatherDataDtoResponse getWeather(String query, String key);
}
