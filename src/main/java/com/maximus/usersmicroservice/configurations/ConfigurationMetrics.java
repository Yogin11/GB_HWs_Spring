package com.maximus.usersmicroservice.configurations;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationMetrics {
    @Autowired
    private MeterRegistry meterRegistry;

    @Bean
    public Timer timer(MeterRegistry meterRegistry){
        return Timer.builder("user_timer_mymetric")
                .description("Timer for user list request process")
                .register(meterRegistry);
    }

    @Bean
    public Counter counter(MeterRegistry meterRegistry){
        return Counter.builder("user_counter_mymetric")
                .description("Counter for user list requests process")
                .register(meterRegistry);
    }

}
