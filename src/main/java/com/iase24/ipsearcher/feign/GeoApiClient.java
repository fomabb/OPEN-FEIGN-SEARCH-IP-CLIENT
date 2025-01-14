package com.iase24.ipsearcher.feign;

import com.iase24.ipsearcher.dto.IpWhoisAppResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "${spring.cloud.openfeign.client.IpApi.com.name}",
        url = "${spring.cloud.openfeign.client.IpWhois.app.url}")
public interface GeoApiClient {

    @GetMapping("/{ip}")
    IpWhoisAppResponse getIpApiCom(@PathVariable("ip") String ip, @RequestParam("lang") String lang);
}
