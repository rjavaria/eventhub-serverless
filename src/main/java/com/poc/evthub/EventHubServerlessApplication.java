package com.poc.evthub;

import com.amazonaws.services.lambda.runtime.events.KinesisEvent;
import com.poc.evthub.beans.ApiResponse;
import com.poc.evthub.config.EventHubProperties;
import com.poc.evthub.function.KinesisEventFunction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Function;


@Slf4j
//@SpringBootConfiguration
@SpringBootApplication
@ComponentScan({ "com.poc.evthub" })
@EnableConfigurationProperties(EventHubProperties.class)
public class EventHubServerlessApplication implements ApplicationContextInitializer<GenericApplicationContext> {

    public EventHubServerlessApplication() {
    }

    public static void main(String[] args) throws Exception {
        FunctionalSpringApplication.run(EventHubServerlessApplication.class, args);
    }

    @Bean
    public KinesisEventFunction ingestEvents() {
        return new KinesisEventFunction();
    }

    @Override
    public void initialize(GenericApplicationContext context) {

        log.debug("========  initialize  ========");

        context.registerBean("ingestEvents", FunctionRegistration.class,
                () -> new FunctionRegistration<Function<KinesisEvent, ApiResponse>>(ingestEvents())
                        .type(FunctionType.from(KinesisEvent.class).to(ApiResponse.class).getType()));
    }
}