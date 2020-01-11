package com.ridango.livetesting;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LiveTestingApplication {

	private TestService testService;

	public static void main(String[] args) {
		SpringApplication.run(LiveTestingApplication.class, args);
	}

	public LiveTestingApplication(TestService testService) {
		this.testService = testService;
	}
}
