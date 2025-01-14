package com.iase24.ipsearcher.controller;

import com.iase24.ipsearcher.dto.LocationClientByIpResponse;
import com.iase24.ipsearcher.numerate.Language;
import com.iase24.ipsearcher.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/info")
@RequiredArgsConstructor
@Validated
@Tag(name = "Поисковик для города по IP API")
public class LocationController {

    private final LocationService locationService;

    @Operation(summary = "Поиск города по IP клиента.",
            description = """
                    Необходимо выбрать доступный язык, после чего выведется информация местоположении на запрашиваемом
                    языке, если язык не поддерживается приложением, по умолчанию выведет информацию на русском языке.
                    """
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ"),
            @ApiResponse(responseCode = "400", description = "Недопустимый язык",
                    content = @Content(schema = @Schema(implementation = RuntimeException.class)))
    })
    @GetMapping("/{lang}/find-city")
    public ResponseEntity<LocationClientByIpResponse> findCity(
            @PathVariable("lang") @Parameter(description = "Язык ответа",
                    schema = @Schema(allowableValues = {"ru", "en", "fr"})) String lang,
            HttpServletRequest request) {
        if (!Language.isValidLanguage(lang)) {
            lang = String.valueOf(Language.ru);
        }
        return ResponseEntity.ok(locationService.getLocationByIp(lang, request));
    }
}
