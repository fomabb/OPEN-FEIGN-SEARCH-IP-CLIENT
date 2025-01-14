package com.iase24.ipsearcher.service;

import com.iase24.ipsearcher.dto.LocationClientByIpResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface LocationService {

    LocationClientByIpResponse getLocationByIp(String lang, HttpServletRequest request);
}
