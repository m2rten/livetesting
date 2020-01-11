package com.ridango.livetesting;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestService {

    private final MeterRegistry meterRegistry;
    private Counter failedTests;
    private Counter allTests;

    public TestService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
       initCounters();

    }
    private void initCounters() {
        failedTests = Counter.builder("tests.failed")    // 2- create a counter using the fluent API
                .tag("type", "kyivlive")
                .description("The number of failed Kyiv Live Tests")
                .register(meterRegistry);


         allTests = Counter.builder("tests.all")    // 2- create a counter using the fluent API
                .tag("type", "kyivlive")
               .description("The number of all Kyiv Live Tests")
              .register(meterRegistry);

    }
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("The time is now");
        failedTests.increment();
        allTests.increment(2.0);
    }
}
