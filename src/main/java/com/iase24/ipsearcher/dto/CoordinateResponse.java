package com.iase24.ipsearcher.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CoordinateResponse {
    private String lon;
    private String lat;
}
