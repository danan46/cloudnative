package com.danan.msvarchetype.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.danan.msvarchetype.api.client.FeignRetryer;

import feign.Retryer;

@Configuration
public class FeignConfig {

	@Bean
	public Retryer retryer() {
		return new FeignRetryer();
	}

}
