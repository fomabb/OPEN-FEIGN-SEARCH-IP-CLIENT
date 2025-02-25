package com.iase24.ipsearcher.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MainWeatherResponse {
    private String temp;
    private String feels_like;
}
