package com.poc.evthub.constant;

import com.amazonaws.regions.Regions;

public final class Constants {

    private Constants() {
        super();
    }

    public static final String REGION = Regions.AP_SOUTHEAST_2.getName();

    public static class SYSENV {
        public static final String SOURCE_DOMAIN = "source_domain";
        public static final String TARGET_STREAM = "target_stream";
        public static final String ENCRYPTION_KEY = "encryption_key";
        public static final String DECRYPTION_KEY = "decryption_key";
    }
}
