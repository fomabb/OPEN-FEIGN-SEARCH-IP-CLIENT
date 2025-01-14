package com.iase24.ipsearcher.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(description = "Сформированное DTO с ответа стороннего API")
public class LocationClientByIpResponse {

    @Pattern(regexp = "([0-9]{1,3}[.]){3}[0-9]{1,3}", message = "ip адрес не валидный")
    @Schema(description = "ip клиента", example = "178.120.2.192")
    private String ip;

    @Schema(description = "Страна", example = "Беларусь")
    private String country;

    @Schema(description = "Город", example = "Брест")
    private String city;

    @Schema(description = "Широта", example = "52.0901")
    private String latitude;

    @Schema(description = "Долгота", example = "23.6836")
    private String longitude;
}
