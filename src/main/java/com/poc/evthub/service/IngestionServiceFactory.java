package com.poc.evthub.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class IngestionServiceFactory {
//    private final List<IIngestionService> serviceList;
//
//    @Autowired
//    public IngestionServiceFactory(List<IIngestionService> serviceList) {
//        this.serviceList = serviceList;
//    }
//
//    public IIngestionService getIngestionService(String domainName) {
//        return serviceList
//                .stream()
//                .filter(service -> service.ingestionSupport(domainName))
//                .findFirst()
//                .orElseThrow(IllegalArgumentException::new);
//    }

    public void ingest() {
        log.info("ingest called...");
    }
}
