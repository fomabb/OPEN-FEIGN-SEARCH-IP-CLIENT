package com.iase24.ipsearcher.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherFromList {

    private String id;
    private String main;
    private String description;
    private String icon;
}
