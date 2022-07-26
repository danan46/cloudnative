package com.danan.msvcommunication.api.server;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actuator")
public class HealthCheckApi {

	@GetMapping(value = "/health", produces = MediaType.TEXT_PLAIN_VALUE)
	public String healthCheck() {
		return "UP";
	}

}
