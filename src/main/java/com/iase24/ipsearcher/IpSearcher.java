package com.iase24.ipsearcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IpSearcher {

	public static void main(String[] args) {
		SpringApplication.run(IpSearcher.class, args);
	}

}
