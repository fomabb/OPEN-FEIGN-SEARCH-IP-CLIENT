package com.iase24.ipsearcher.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(description = "Ответ с стороннего API")
public class IpApiComResponse {

    @Schema(description = "ip клиента", example = "178.120.2.192")
    private String query;

    @Schema(description = "Страна", example = "Беларусь")
    private String country;

    @Schema(description = "Город", example = "Брест")
    private String city;

    @Schema(description = "Широта", example = "52.0901")
    private String lat;

    @Schema(description = "Долгота", example = "23.6836")
    private String lon;
}
