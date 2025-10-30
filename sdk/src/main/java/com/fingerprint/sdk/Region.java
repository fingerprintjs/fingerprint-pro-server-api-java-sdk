package com.fingerprint.sdk;

public enum Region {
    GLOBAL ("https://api.fpjs.io/v4"),
    EUROPE ("https://eu.api.fpjs.io/v4"),
    ASIA ("https://ap.api.fpjs.io/v4");
    private final String url;

    Region(String s) {
        url = s;
    }

    public String toString() {
        return this.url;
    }
}
