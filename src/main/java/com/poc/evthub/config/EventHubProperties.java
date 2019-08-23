package com.poc.evthub.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "evthub", ignoreUnknownFields = false)
public class EventHubProperties {
    private String sourceDomain;
    private String targetStream;
    private String encryptionKey;
    private String decryptionKey;
    private boolean testEnv = false;
    private Long retryPollingDelay;
    private Long retryFixedRate = new Long(60000);
    private Long retryInitialDelay=new Long(30000);
    private Integer retryBatchSize = 10;

    public String getSourceDomain() {
        return sourceDomain;
    }

    public void setSourceDomain(String sourceDomain) {
        this.sourceDomain = sourceDomain;
    }

    public String getTargetStream() {
        return targetStream;
    }

    public void setTargetStream(String targetStream) {
        this.targetStream = targetStream;
    }

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public String getDecryptionKey() {
        return decryptionKey;
    }

    public void setDecryptionKey(String decryptionKey) {
        this.decryptionKey = decryptionKey;
    }

    public Integer getRetryBatchSize() {
        return retryBatchSize;
    }

    public void setRetryBatchSize(Integer retryBatchSize) {
        this.retryBatchSize = retryBatchSize;
    }

    public Long getRetryFixedRate() {
        return retryFixedRate;
    }

    public void setRetryFixedRate(Long retryFixedRate) {
        this.retryFixedRate = retryFixedRate;
    }

    public Long getRetryInitialDelay() {
        return retryInitialDelay;
    }

    public void setRetryInitialDelay(Long retryInitialDelay) {
        this.retryInitialDelay = retryInitialDelay;
    }

    public Long getRetryPollingDelay() {
        return retryPollingDelay;
    }

    public void setRetryPollingDelay(Long retryPollingDelay) {
        this.retryPollingDelay = retryPollingDelay;
    }


    public boolean isTestEnv() {
        return testEnv;
    }

    public void setTestEnv(boolean testEnv) {
        this.testEnv = testEnv;
    }
}
