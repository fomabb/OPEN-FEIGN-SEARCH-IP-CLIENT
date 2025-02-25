package com.iase24.ipsearcher.feign;

import com.iase24.ipsearcher.dto.WeatherDataDtoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "${spring.cloud.openfeign.weather.app.name}",
        url = "${spring.cloud.openfeign.weather.app.url}"
)
public interface GetWeatherResponseApiFeign {

    @GetMapping
    WeatherDataDtoResponse getWeather(@RequestParam("q") String q, @RequestParam("appid") String appid);
}
