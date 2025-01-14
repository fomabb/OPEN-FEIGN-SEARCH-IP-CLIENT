package com.iase24.ipsearcher.service.impl;

import com.iase24.ipsearcher.dto.IpWhoisAppResponse;
import com.iase24.ipsearcher.dto.LocationClientByIpResponse;
import com.iase24.ipsearcher.feign.GeoApiClient;
import com.iase24.ipsearcher.service.LocationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LocationServiceImpl implements LocationService {

    private final GeoApiClient geoApiClient;

    @Override
    public LocationClientByIpResponse getLocationByIp(String lang, HttpServletRequest request) {
        Optional<String> ipAddressClient = Optional.ofNullable(getClientIP(request));
        IpWhoisAppResponse response = ipResponse(ipAddressClient
                .orElseThrow(() -> new RuntimeException(
                        String.format("Ip address: %s, not found", ipAddressClient))), lang);

        if (response == null || response.getCity() == null) {
            return LocationClientByIpResponse.builder().city("Жабинка").build();
        }

        return LocationClientByIpResponse.builder()
                .ip(Objects.requireNonNull(response).getIp() != null ? response.getIp() : "unknown")
                .country(response.getCountry() != null ? response.getCountry() : "unknown")
                .city(response.getCity() != null ? response.getCity() : "unknown")
                .latitude(response.getLatitude() != null ? response.getLatitude() : "unknown")
                .longitude(response.getLongitude() != null ? response.getLongitude() : "unknown")
                .build();
    }

    private IpWhoisAppResponse ipResponse(String ip, String lang) {
        return geoApiClient.getIpApiCom(ip, lang);
    }

    private String getClientIP(HttpServletRequest request) {
        String forwardHeader = request.getHeader("X-Forwarded-For");
        if (forwardHeader != null) {
            return forwardHeader.split(",")[0];
        }
        return request.getRemoteAddr();
    }
}
